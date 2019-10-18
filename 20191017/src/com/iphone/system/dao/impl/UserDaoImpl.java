package com.iphone.system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iphone.system.dao.IUserDao;
import com.iphone.system.pojo.User;
import com.iphone.system.util.DBUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public List<User> getUsersByPage(int size, int pageno) {
		

		
			List<User> users = new ArrayList<User>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select * from use_msg limit?,?";
			
			try {
				conn = DBUtil.getConnetion();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, size*(pageno-1));
				pstmt.setInt(2, size);
				
				rs = pstmt.executeQuery();

				
				while(rs.next()) {
					User u = new User();
					u.setDepa(rs.getString("depa"));
					u.setId(rs.getInt("id"));
					u.setSex(rs.getString("sex"));
					u.setTel(rs.getString("tel"));
					u.setUname(rs.getString("uname"));
					
					users.add(u);
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(conn, pstmt, rs);
			}
			
			return users;
		
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from use_msg";
		
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				User u = new User();
				u.setDepa(rs.getString("depa"));
				u.setId(rs.getInt("id"));
				u.setSex(rs.getString("sex"));
				u.setTel(rs.getString("tel"));
				u.setUname(rs.getString("uname"));
				
				users.add(u);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return users;
	}

}
