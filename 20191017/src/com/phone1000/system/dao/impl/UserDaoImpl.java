package com.phone1000.system.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import com.phone1000.system.dao.IUserDao;
import com.phone1000.system.pojo.User;
import com.phone1000.system.util.DBUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public List<User> getUsersByPage(int size, int pageno) {
	
			List<User> users = new ArrayList<User>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "select * from user_msg limit ?,?";
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
		String sql = "select * from user_msg ";
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
