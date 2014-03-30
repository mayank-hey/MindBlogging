/**
 * 
 */
package edu.web.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import edu.web.dainterface.IUserDao;

/**
 * @author rohansabnis
 * 
 */
public class UserDao extends SimpleJdbcDaoSupport implements IUserDao {

	public int check_user(String user_name) {
		int flag = 0;

		flag = getSimpleJdbcTemplate().queryForInt(
				"select count(*) from user_info where user_name = :user_name",
				new MapSqlParameterSource().addValue("user_name", user_name));

		return flag;
	}
}
