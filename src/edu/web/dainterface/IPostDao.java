/**
 * 
 */
package edu.web.dainterface;

import java.util.List;

import edu.web.bean.PostInfo;

/**
 * @author rohansabnis
 *
 */
public interface IPostDao {
	
	public PostInfo addPost(PostInfo postInfo);
	public PostInfo getaddedPost(String user_name);
	public List<PostInfo> getBlogPosts(PostInfo postInfo);
	public PostInfo updatePost(PostInfo postInfo);

}
