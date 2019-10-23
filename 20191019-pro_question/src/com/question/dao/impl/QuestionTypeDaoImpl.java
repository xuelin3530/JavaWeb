package com.question.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.question.dao.IQuestionTypeDao;
import com.question.pojo.QuestionType;
import com.question.util.DBUtil;

public class QuestionTypeDaoImpl implements IQuestionTypeDao {

	@Override
	public List<QuestionType> getAllTypes() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<QuestionType> list = new ArrayList<QuestionType>();
		String sql ="select * from questiontype";
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionType qt = new QuestionType();
				qt.setTid(rs.getInt("tid"));
				qt.setTname(rs.getString("tname"));
				
				list.add(qt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public static void main(String[] args) {
		QuestionTypeDaoImpl dao = new QuestionTypeDaoImpl();
		System.out.println(dao.getAllTypes().size());
	}

}
