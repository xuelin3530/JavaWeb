package com.library.system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.library.system.dao.IUserDao;
import com.library.system.pojo.User;
import com.library.system.util.DBUtil;

public class UserDaoImpl2 implements IUserDao{

	@Override
	public String login(User u) {
		
		try {
			Connection conn = DBUtil.getConnetion();
			String sql = "SELECT password,name FROM User WHERE user=?";
			PreparedStatement pst = null;
			ResultSet rs = null;
			pst = conn.prepareStatement(sql);
			pst.setString(1, u.getUsername());
			rs = pst.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "password";
			
		}
		
	}
	
	


