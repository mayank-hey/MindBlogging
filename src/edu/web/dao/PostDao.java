/**
 * 
 */
package edu.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import edu.web.bean.PostInfo;
import edu.web.common.Constants;
import edu.web.dainterface.IPostDao;

/**
 * @author rohansabnis
 * 
 */
public class PostDao extends SimpleJdbcDaoSupport implements IPostDao {

	public PostInfo addPost(PostInfo postInfo) {

		int count = getSimpleJdbcTemplate()
				.update("insert into post_info(user_name,post_title,post_text,post_terms,emo_score,timestamp) values (:user_name,:post_title,:post_text,:post_terms,:emo_score,:timestamp)",
						new MapSqlParameterSource()
								.addValue(Constants.user_name,
										postInfo.getUser_name())
								.addValue(Constants.post_title,
										postInfo.getPost_title())
								.addValue(Constants.post_text,
										postInfo.getPost_text())
								.addValue(Constants.post_terms,
										postInfo.getPost_terms_list())
								.addValue(Constants.emo_score,
										postInfo.getEmo_score())
								.addValue(Constants.timestamp,
										postInfo.getTimestamp()));
		postInfo = getaddedPost(postInfo.getUser_name());
		return postInfo;
	}

	public PostInfo getaddedPost(String user_name) {
		List<PostInfo> postInfoList = getSimpleJdbcTemplate()
				.query("select * from post_info where post_id=(select max(post_id) from post_info where user_name=:user_name)",
						new PostInfoMapper(),
						new MapSqlParameterSource().addValue(
								Constants.user_name, user_name));
		return postInfoList.get(0);
	}

	public List<PostInfo> getBlogPosts(PostInfo postInfo) {
		List<PostInfo> postInfoList = getSimpleJdbcTemplate()
				.query("select * from post_info where user_name=:user_name order by post_id desc",
						new PostInfoMapper(),
						new MapSqlParameterSource().addValue(
								Constants.user_name, postInfo.getUser_name()));
		return postInfoList;
	}

	public PostInfo updatePost(PostInfo postInfo) {
		int count = getSimpleJdbcTemplate()
				.update("update post_info set emo_score=:emo_score where post_id=:post_id",
						new MapSqlParameterSource().addValue(Constants.emo_score, postInfo.getEmo_score())
								.addValue(Constants.post_id,
										postInfo.getPost_id()));
		return postInfo;
	}

	private static class PostInfoMapper implements
			ParameterizedRowMapper<PostInfo> {

		public PostInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
			PostInfo postInfo = new PostInfo();
			postInfo.setPost_id(rs.getInt(edu.web.common.Constants.post_id));
			postInfo.setUser_name(rs
					.getString(edu.web.common.Constants.user_name));
			postInfo.setPost_title(rs
					.getString(edu.web.common.Constants.post_title));
			postInfo.setPost_text(rs
					.getString(edu.web.common.Constants.post_text));
			postInfo.setPost_terms_list(rs
					.getString(edu.web.common.Constants.post_terms));
			postInfo.setEmo_score(rs.getInt(Constants.emo_score));
			postInfo.setTimestamp(rs.getString(Constants.timestamp).toString());

			return postInfo;
		}
	}

}
