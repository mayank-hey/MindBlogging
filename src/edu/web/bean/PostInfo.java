/**
 * 
 */
package edu.web.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author rohansabnis
 * 
 */
public class PostInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	private int post_id;
	private String user_name;
	private String post_title;
	private String post_text;
	private List<String> post_terms;
	private String post_terms_list;
	private int emo_score;
	private String timestamp;

	/**
	 * @return the post_id
	 */
	public int getPost_id() {
		return post_id;
	}

	/**
	 * @param post_id
	 *            the post_id to set
	 */
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name
	 *            the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the post_title
	 */
	public String getPost_title() {
		return post_title;
	}

	/**
	 * @param post_title
	 *            the post_title to set
	 */
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}

	/**
	 * @return the post_text
	 */
	public String getPost_text() {
		return post_text;
	}

	/**
	 * @param post_text
	 *            the post_text to set
	 */
	public void setPost_text(String post_text) {
		this.post_text = post_text;
	}

	/**
	 * @return the post_terms
	 */
	public List<String> getPost_terms() {
		return post_terms;
	}

	/**
	 * @param post_terms
	 *            the post_terms to set
	 */
	public void setPost_terms(List<String> post_terms) {
		this.post_terms = post_terms;
	}

	/**
	 * @return the emo_score
	 */
	public int getEmo_score() {
		return emo_score;
	}

	/**
	 * @param emo_score
	 *            the emo_score to set
	 */
	public void setEmo_score(int emo_score) {
		this.emo_score = emo_score;
	}

	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp
	 *            the timestamp to set
	 */
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the post_terms_list
	 */
	public String getPost_terms_list() {
		return post_terms_list;
	}

	/**
	 * @param post_terms_list the post_terms_list to set
	 */
	public void setPost_terms_list(String post_terms_list) {
		this.post_terms_list = post_terms_list;
	}

}
