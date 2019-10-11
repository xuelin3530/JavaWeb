package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Employee;
import com.pojo.Post;
import com.utils.DBUtil;

public class EmployeeDao {
	
	//根据条件查询员工信息
	public List<Employee> getEmpsByNameOrPost(Employee emp){
		List<Employee> emps = new ArrayList<Employee>();
		List<String> params = new ArrayList<String>();
		
		String sql = "select e.* , p.* from employee e inner join post p on e.post_id = p.post_id where 1=1 ";
		if(emp.getName()!=null) {
			sql = sql + " and e.emp_name like ?"; 
			params.add("%"+emp.getName()+"%");
		}
		if(emp.getPost().getName()!=null) {
			sql = sql + " and p.post_name = ?";
			params.add(emp.getPost().getName());
		}
		System.out.println(params);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0; i<params.size();i++) {
				pstmt.setString(i+1, params.get(i));
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee e = new Employee();
				
				e.setAge((Integer)rs.getObject("emp_age"));
				e.setDepart(rs.getString("emp_depart"));
				e.setId(rs.getInt("emp_id"));
				e.setName(rs.getString("emp_name"));
				e.setSex(rs.getString("emp_sex"));
				e.setYear((Integer)rs.getObject("emp_year"));
				 
				Post post = new Post();
				post.setDesc(rs.getString("post_desc"));
				post.setId(rs.getInt("post_id"));
				post.setName(rs.getString("post_name"));
				
				e.setPost(post);
				emps.add(e);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		
		return emps;
	}
	
	public static void main(String[] args) {
		EmployeeDao ed = new EmployeeDao();
		Employee emp = new Employee();
//		emp.setName("李");
//		emp.getPost().setName("行政助理");
		List<Employee> list = ed.getEmpsByNameOrPost(emp);
		for(Employee e : list) {
			System.out.println(e);

		}
	}
}


