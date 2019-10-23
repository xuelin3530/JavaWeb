package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pojo.Dept;
import com.utils.DBUtil;

public class DeptDao {
	
	//根据主键查询Dept对象
	public Dept getDeptByNo(int no) {
		Dept dept = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from dept where deptno  = ?";
		
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dept = new Dept();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return dept;
	}
	
	
	//插入Dept对象
	public int addDept(Dept d) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into dept values (?,?,?)";
		
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d.getDeptno());
			pstmt.setString(2, d.getDname());
			pstmt.setString(3, d.getLoc());
			
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, null);
		}
		
		
		
		
		return rs;
	}
}
