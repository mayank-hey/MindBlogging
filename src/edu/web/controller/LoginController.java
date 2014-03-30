/**
 * 
 */
package edu.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.web.bean.PostInfo;
import edu.web.bean.UserInfo;
import edu.web.dainterface.IPostDao;
import edu.web.dainterface.IUserDao;

/**
 * @author rohansabnis
 * 
 */

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	private IPostDao postDao;
	private IUserDao userDao;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processlogin(
			@ModelAttribute("userInfo") UserInfo userinfo,
			Map<String, Object> myModel) throws ServletException, IOException {

		int flag = 0;
		String user_name = "";
		String password = "";

		user_name = userinfo.getUser_name();
		password = userinfo.getPassword();

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
		myModel.put("logged_in_user", user_name);
		if (post_info_list != null && post_info_list.size()!=0)
			myModel.put("emo_score", post_info_list.get(0).getEmo_score());
		else
			myModel.put("emo_score", 0);

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
