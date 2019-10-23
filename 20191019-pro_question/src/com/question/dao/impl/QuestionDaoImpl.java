package com.question.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.question.dao.IQuestionDao;
import com.question.pojo.Question;
import com.question.pojo.QuestionType;
import com.question.util.DBUtil;

public class QuestionDaoImpl implements IQuestionDao {

	@Override
	public List<Integer> getAllLevel() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select distinct level from question order by level asc";
		List<Integer> list = new ArrayList<Integer>();
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("level"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Question> getAllQuestionsByType(int type, int level) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Question> list = new ArrayList<Question>();
		String sql ="select q.*, qt.* from question q inner join questiontype qt on q.type = qt.tid where 1=1";
		if(type!=0) {
			sql += " and qt.tid = "+type;
		}
		if(level!=0) {
			sql += " and q.level = "+level;
		}
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Question q = new Question();
				q.setAns1(rs.getString("ans1"));
				q.setAns2(rs.getString("ans2"));
				q.setAns3(rs.getString("ans3"));
				q.setAns4(rs.getString("ans4"));
				q.setAuthor(rs.getString("author"));
				q.setId(rs.getInt("id"));
				q.setLevel(rs.getInt("level"));
				q.setQuestion(rs.getString("question"));
				
				QuestionType qt = new QuestionType();
				qt.setTid(rs.getInt("tid"));
				qt.setTname(rs.getString("tname"));
				q.setType(qt);
				
				list.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Question> getQuestionsByCondition(int typeid, int level,int pageno, int size) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql ="select q.*, qt.* from question q inner join questiontype qt on q.type = qt.tid where 1=1 ";
		List<Object> params = new ArrayList<Object>();
		if(typeid !=0) {
			sql += " and qt.tid = ?";
			params.add(typeid);
		}
		if(level !=0) {
			sql += " and q.level = ?";
			params.add(level);
		}
		sql += " limit ?,?";
		params.add(size*(pageno-1));
		params.add(size);
		List<Question> list = new ArrayList<Question>();
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			for(int i=0; i<params.size(); i++) {
				pstmt.setObject(i+1, params.get(i));
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Question q = new Question();
				q.setAns1(rs.getString("ans1"));
				q.setAns2(rs.getString("ans2"));
				q.setAns3(rs.getString("ans3"));
				q.setAns4(rs.getString("ans4"));
				q.setAuthor(rs.getString("author"));
				q.setId(rs.getInt("id"));
				q.setLevel(rs.getInt("level"));
				q.setQuestion(rs.getString("question"));
				
				QuestionType qt = new QuestionType();
				qt.setTid(rs.getInt("tid"));
				qt.setTname(rs.getString("tname"));
				q.setType(qt);
				
				list.add(q);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public static void main(String[] args) {
		QuestionDaoImpl dao = new QuestionDaoImpl();
		//System.out.println(dao.getAllLevel());
		System.out.println(dao.getAllQuestionsByType(0,0).size());
//		List<Question> list = dao.getQuestionsByCondition(1, 3, 1, 10);
//		for(Question q : list) {
//			System.out.println(q);
//		}
	}

}
