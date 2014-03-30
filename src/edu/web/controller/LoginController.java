/**
 * 
 */
package edu.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import edu.web.bean.PostInfo;
import edu.web.dainterface.IPostDao;
import edu.web.dainterface.IUserDao;

/**
 * @author rohansabnis
 * 
 */

public class LoginController implements Controller {

	private IPostDao postDao;
	private IUserDao userDao;

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int flag = 0;
		Map<String, Object> myModel = new HashMap<String, Object>();
		String user_name = "";
		String password = "";

		Map<String, String[]> parameters = request.getParameterMap();
		if (parameters.get("user_id") != null
				&& parameters.get("password") != null) {
			user_name = parameters.get("user_name")[0].toString();
			password = parameters.get("password")[0].toString();
		}
		List<PostInfo> post_info_list = new ArrayList<PostInfo>();
		flag = this.userDao.check_user(user_name, password);

		if (flag == 1) {
			PostInfo postInfo = new PostInfo();
			postInfo.setUser_name(user_name);
			post_info_list = this.postDao.getBlogPosts(postInfo);

			for (int i = 0; i < post_info_list.size(); i++) {
				String term_list = post_info_list.get(i).getPost_terms_list();
				if (term_list.contains(",")) {
					String[] terms_array = term_list.split(",");
					post_info_list.get(i).setPost_terms(
							Arrays.asList(terms_array));
				} else {
					List terms = new ArrayList();
					terms.add(term_list);
					post_info_list.get(i).setPost_terms(terms);
				}
			}
		}
		myModel.put("post_info_list", post_info_list);

		return new ModelAndView("profile", "model", myModel);

	}

	/**
	 * @return the postDao
	 */
	public IPostDao getPostDao() {
		return postDao;
	}

	/**
	 * @param postDao
	 *            the postDao to set
	 */
	public void setPostDao(IPostDao postDao) {
		this.postDao = postDao;
	}

	/**
	 * @return the userDao
	 */
	public IUserDao getUserDao() {
		return userDao;
	}

	/**
	 * @param userDao
	 *            the userDao to set
	 */
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
