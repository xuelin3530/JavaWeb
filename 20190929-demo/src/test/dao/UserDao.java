package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.pojo.User;
import test.util.DBUtils;

public class UserDao {
	
	public List<User> getAllUser(){
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql ="select id, username, password from user_tab";
		try {
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
				list.add(u);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBUtils.close(conn, pstmt, rs);
			
		}
		
		return list;
	}
	
	
	
	//根据登录名获取User对象
	public User getUserByName(String name) {
		User u = null;
		Connection conn = null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		String sql ="select id, username, password from user_tab where username = ?";
		
		try {
			
			conn = DBUtils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setUsername(rs.getString(2));
				u.setPassword(rs.getString(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, pstmt, rs);
			
		}
		
		return u;
	}
}
