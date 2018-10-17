package com.sauzny.sbdatasourcedemo.statementcancel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

@Component
public class DBTemplate {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private StatementCache statementCache;
	
	public List<Integer> executeQuery(String sqlKey, String sql) {
		
		List<Integer> result = Lists.newArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DataSourceUtils.getConnection(dataSource);
			ps = con.prepareStatement(sql);
			// ps对象加入缓存中
			statementCache.put(sqlKey, ps);
			ResultSet rs = ps.executeQuery();
			//if(true) ps.cancel();
			//ps.cancel();
			//rs 变形
			while(rs.next()){
				result.add(rs.getInt("a"));
			}
		} catch (SQLException sqle) {
			// sql异常
			sqle.printStackTrace();
		} finally {
			// close
			try{
				if(ps != null) ps.close();
				if(con != null) DataSourceUtils.releaseConnection(con, dataSource);
			}catch(SQLException e) {
				// nothing
			}
			// remove ps
			statementCache.remove(sqlKey);
		}
		
		return result;
	}
	
	public String cancelQuery(String sqlKey) {
		PreparedStatement ps = statementCache.get(sqlKey);
		if(ps != null) {
			try {
				ps.cancel();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sqlKey;
	}
	
}
