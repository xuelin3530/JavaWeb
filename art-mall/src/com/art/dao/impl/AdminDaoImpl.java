package com.art.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.art.dao.IAdminDao;
import com.art.pojo.Admin;
import com.art.util.DBUtil;

public class AdminDaoImpl implements IAdminDao{


	@Override
	public Admin getAdminByName(String admin_name) {
		Admin admin = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		String sql="SELECT id,admin,password FROM admin WHERE admin=?";
		try {
			
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin_name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				admin = new Admin();
				admin.setAdmin_id(rs.getInt(1));
				admin.setAdmin_name(rs.getString(2));
				admin.setAdmin_password(rs.getString(3));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return admin;
	}

	
}
