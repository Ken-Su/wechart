package com.wx.platform.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class BaseDao extends NamedParameterJdbcDaoSupport {
	
	
	@Autowired
	public BaseDao(JdbcTemplate jdbcTemplate) {
       setJdbcTemplate(jdbcTemplate);
    }

	
	/**
	 * 适用于更新数据库,insert,update, delete都可以用
	 * 
	 * @param namedSql
	 *            :命名参数的SQL语句，而且参数的命名必须和javaBean中的属性名对应
	 * @param javaBean
	 *            ：javaBean对象
	 * @return
	 */
	public int update(String namedSql, Object javaBean) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(
				javaBean);
		return this.getNamedParameterJdbcTemplate().update(namedSql,
				paramSource);
	}

	/**
	 * 普通sql, 传进去的sql语句中的参数是问号不是命名
	 * @param sql
	 * @param paramValue
	 * @return
	 */
	public int commonUpdate(String sql, Object... paramValue) {
		return this.getJdbcTemplate().update(sql, paramValue);
	}

	public <T> T getJavaBean(String sql, Class<T> returnType, Object... paramValue) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(returnType);
		try {
			return this.getJdbcTemplate().queryForObject(sql, rowMapper,paramValue);
		} catch (Exception ex) {
			return null;
		}
	}

	public <T> List<T> getList(String sql, Class<T> returnType, Object... paramValue) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(returnType);
		return this.getJdbcTemplate().query(sql, rowMapper, paramValue);
	}

	public <T> List<T> getList(String sql, Class<T> returnType) {
		RowMapper<T> rowMapper = new BeanPropertyRowMapper<T>(returnType);
		return this.getJdbcTemplate().query(sql, rowMapper);
	}
}
