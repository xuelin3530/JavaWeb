package com.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.IUserDao;
import java.sql.PreparedStatement;
import com.pojo.User;
import com.utils.DBUtil;

public class UserDaoImpl implements IUserDao {

	@Override
	public List<User> getAllUsers() {
		List<User>  users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user_msg";
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

	@Override
	public int addUser(User user) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		
		String sql = "insert into user_msg values (default, ?,?,?,?)";
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getSex());
			pstmt.setString(3, user.getTel());
			pstmt.setString(4, user.getDepa());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, null);
		}
		return cnt;
	}

	@Override
	public int updateUser(User user) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "update user_msg set uname=?, sex=?, tel=?, depa=? where id =?";
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getSex());
			pstmt.setString(3, user.getTel());
			pstmt.setString(4, user.getDepa());
			pstmt.setInt(5, user.getId());
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public int deleteUser(int id) {
		int cnt=0;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "delete from user_msg where id = ?";
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public User getUserById(int id) {
		User user = null;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user_msg where id = ?";
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setDepa(rs.getString("depa"));
				user.setId(rs.getInt("id"));
				user.setSex(rs.getString("sex"));
				user.setTel(rs.getString("tel"));
				user.setUname(rs.getString("uname"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return user;
	}

	

	@Override
	public List<User> getUsersByDepa(String depa) {
		List<User>  users = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "select * from user_msg where depa = ?";
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, depa);
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
	
	public static void main(String[] args) {
		UserDaoImpl ud = new UserDaoImpl();
		//System.out.println(ud.getUsersByDepa("教学部"));
		//System.out.println(ud.getUserById(1));
		//User u = new User("aaa","男","1234567","教学部");
		//System.out.println(ud.addUser(u));
//		u.setId(13);
//		u.setDepa("市场部");
//		System.out.println(ud.updateUser(u));
		System.out.println(ud.deleteUser(13));
		
		
	}
}
