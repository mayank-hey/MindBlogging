/**
 * 
 */
package edu.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.web.bean.PostInfo;
import edu.web.dainterface.IPostDao;
import edu.web.dainterface.IUserDao;

/**
 * @author rohansabnis
 * 
 */
public class PostInfoController {

	private IPostDao postDao;
	private IUserDao userDao;

	@RequestMapping(value = "/add_post", method = RequestMethod.POST)
	public @ResponseBody
	PostInfo add(@RequestBody PostInfo postInfo) throws Exception {

		int flag = 0;
		flag = this.userDao.check_user(postInfo.getUser_name());

		if (flag == 1) {
			if (postInfo.getPost_terms() != null
					&& postInfo.getPost_terms().size() != 0) {
				System.out.println("inside list loop");
				String term_list = "";
				for (int i = 0; i < postInfo.getPost_terms().size(); i++) {
					if (i == 0)
						term_list = postInfo.getPost_terms().get(i);
					else
						term_list = term_list + ","
								+ postInfo.getPost_terms().get(i);
				}
				postInfo.setPost_terms_list(term_list);
			}
			postInfo = this.postDao.addPost(postInfo);
		}

		return postInfo;
	}

	@RequestMapping(value = "/fetch_blog_posts", method = RequestMethod.POST)
	public @ResponseBody
	List<PostInfo> fetch_posts(@RequestBody PostInfo postInfo) throws Exception {
		List<PostInfo> post_info_list = new ArrayList<PostInfo>();

		post_info_list = this.postDao.getBlogPosts(postInfo);

		for (int i = 0; i < post_info_list.size(); i++) {
			String term_list = post_info_list.get(i).getPost_terms_list();
			String[] terms_array = term_list.split(",");
			post_info_list.get(i).setPost_terms(Arrays.asList(terms_array));
		}

		return post_info_list;
	}

	@RequestMapping(value = "/update_post", method = RequestMethod.POST)
	public @ResponseBody
	PostInfo update(@RequestBody PostInfo postInfo) throws Exception {

		if (postInfo.getPost_terms() != null
				&& postInfo.getPost_terms().size() != 0) {
			String term_list = "";
			for (int i = 0; i < postInfo.getPost_terms().size(); i++) {
				if (i == 0)
					term_list = postInfo.getPost_terms().get(i);
				else
					term_list = term_list + ","
							+ postInfo.getPost_terms().get(i);
			}
		}

		postInfo = this.postDao.updatePost(postInfo);
		return postInfo;
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
