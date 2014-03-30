/**
 * 
 */
package edu.web.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.web.bean.AnalysisResult;
import edu.web.bean.PostInfo;
import edu.web.bo.SkyttleClient;
import edu.web.dainterface.IPostDao;
import edu.web.util.Calculator;

/**
 * @author rohansabnis
 * 
 */
public class PostInfoController {

	private IPostDao postDao;
	// private IUserDao userDao;
	private SkyttleClient skyttleClient;

	@RequestMapping(value = "/add_post", method = RequestMethod.POST)
	public @ResponseBody
	List<PostInfo> add(@RequestBody PostInfo postInfo) throws Exception {

		int flag = 0;
		AnalysisResult analResult = new AnalysisResult();
		// flag = this.userDao.check_user(postInfo.getUser_name());

		// if (flag == 1) {
		analResult = this.skyttleClient.analyzeText(postInfo.getPost_text());
		postInfo.setEmo_score(analResult.getEmoScore());
		postInfo.setPost_terms(analResult.getKeywords());
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
			postInfo.setPost_terms_list(term_list);
		}

		String format = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String date_mysql = sdf.format(new Date());
		postInfo.setTimestamp(date_mysql);

		postInfo = this.postDao.addPost(postInfo);
		// }

		List<PostInfo> post_info_list = new ArrayList<PostInfo>();

		post_info_list = this.postDao.getBlogPosts(postInfo);
		String term_list = "";
		for (int i = 0; i < post_info_list.size(); i++) {
			if (post_info_list.get(i).getPost_terms_list() != null) {
				term_list = post_info_list.get(i).getPost_terms_list();
				if (term_list.contains(",")) {
					String[] terms_array = term_list.split(",");
					post_info_list.get(i).setPost_terms(
							Arrays.asList(terms_array));
				} else {
					List terms = new ArrayList();
					terms.add(term_list);
					post_info_list.get(i).setPost_terms(terms);
				}
			} else {
				List terms = new ArrayList();
				terms.add(term_list);
				post_info_list.get(i).setPost_terms(terms);
			}
		}

		return post_info_list;
	}

	@RequestMapping(value = "/fetch_blog_posts", method = RequestMethod.POST)
	public @ResponseBody
	List<PostInfo> fetch_posts(@RequestBody PostInfo postInfo) throws Exception {
		List<PostInfo> post_info_list = new ArrayList<PostInfo>();

		post_info_list = this.postDao.getBlogPosts(postInfo);

		for (int i = 0; i < post_info_list.size(); i++) {
			String term_list = post_info_list.get(i).getPost_terms_list();
			if (term_list.contains(",")) {
				String[] terms_array = term_list.split(",");
				post_info_list.get(i).setPost_terms(Arrays.asList(terms_array));
			} else {
				List terms = new ArrayList();
				terms.add(term_list);
				post_info_list.get(i).setPost_terms(terms);
			}
		}

		return post_info_list;
	}

	@RequestMapping(value = "/update_post", method = RequestMethod.POST)
	public @ResponseBody
	List<PostInfo> update(@RequestBody PostInfo postInfo) throws Exception {

//		if (postInfo.getPost_terms() != null
//				&& postInfo.getPost_terms().size() != 0) {
//			String term_list = "";
//			for (int i = 0; i < postInfo.getPost_terms().size(); i++) {
//				if (i == 0)
//					term_list = postInfo.getPost_terms().get(i);
//				else
//					term_list = term_list + ","
//							+ postInfo.getPost_terms().get(i);
//			}
//			postInfo.setPost_terms_list(term_list);
//		}
		
		List<PostInfo> tmp_post_info_list = new ArrayList<PostInfo>();

		tmp_post_info_list = this.postDao.getBlogPosts(postInfo);
		postInfo.setPost_id(tmp_post_info_list.get(0).getPost_id());
		postInfo = this.postDao.updatePost(postInfo);
		List<PostInfo> post_info_list = new ArrayList<PostInfo>();

		post_info_list = this.postDao.getBlogPosts(postInfo);

		for (int i = 0; i < post_info_list.size(); i++) {
			String term_list = post_info_list.get(i).getPost_terms_list();
			if (term_list.contains(",")) {
				String[] terms_array = term_list.split(",");
				post_info_list.get(i).setPost_terms(Arrays.asList(terms_array));
			} else {
				List terms = new ArrayList();
				terms.add(term_list);
				post_info_list.get(i).setPost_terms(terms);
			}
		}

		return post_info_list;

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
	 * @param skyttleClient
	 *            the skyttleClient to set
	 */
	public void setSkyttleClient(SkyttleClient skyttleClient) {
		this.skyttleClient = skyttleClient;
	}

}
