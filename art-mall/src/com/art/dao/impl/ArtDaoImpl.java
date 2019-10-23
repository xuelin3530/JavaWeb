package com.art.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.art.dao.IArtDao;
import com.art.pojo.Art;
import com.art.util.DBUtil;

public class ArtDaoImpl implements IArtDao{

	@Override
	public int addArt(Art art) {
		
		String sql = "insert into art values (default, ?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, art.getArt_name());
			pstmt.setString(2, art.getArt_price());
			pstmt.setString(3, art.getArt_introduction());
			pstmt.setString(4, art.getArt_detail());
			pstmt.setString(5, art.getArt_cover());
					
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<Art> getAllArts() {
		String sql = "select * from art";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Art> arts = new ArrayList<Art>();
		
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Art art = new Art();
				
				art.setArt_id(rs.getInt("id"));
				art.setArt_name(rs.getString("art"));
				art.setArt_price(rs.getString("price"));
				art.setArt_introduction(rs.getString("introduce"));
				art.setArt_detail(rs.getString("detail"));
				art.setArt_cover(rs.getString("cover"));
				arts.add(art);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return arts;
	}

	@Override
	public int updateArt(Art art) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "update art set art=?, price=?, introduce=?, detail=?, cover=? where id =?";
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, art.getArt_name());
			pstmt.setString(2, art.getArt_price());
			pstmt.setString(3, art.getArt_introduction());
			pstmt.setString(4, art.getArt_detail());
			pstmt.setString(5, art.getArt_cover());
			pstmt.setInt(6, art.getArt_id());
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return cnt;
	}
	
	@Override
	public int deleteArt(int id) {
		int cnt=0;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "delete from art where id = ?";
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
	public Art getArtById(int id) {
		Art art = null;
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		String sql = "select * from art where id = ?";
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				art = new Art();
				art.setArt_name(rs.getString("art"));
				art.setArt_price(rs.getString("price"));
				art.setArt_introduction(rs.getString("introduce"));
				art.setArt_detail(rs.getString("detail"));
				art.setArt_cover(rs.getString("cover"));
				art.setArt_id(rs.getInt("id"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return art;
	}

	@Override
	public List<Art> getArtsByPage(int size, int pageno) {
		List<Art> arts = new ArrayList<Art>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from art limit ?,?";
		try {
			conn = DBUtil.getConnetion();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, size*(pageno-1));
			pstmt.setInt(2, size);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Art art = new Art();
				art.setArt_name(rs.getString("art"));
				art.setArt_price(rs.getString("price"));
				art.setArt_introduction(rs.getString("introduce"));
				art.setArt_detail(rs.getString("detail"));
				art.setArt_cover(rs.getString("cover"));
				art.setArt_id(rs.getInt("id"));
				
				
				
				arts.add(art);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, pstmt, rs);
		}
		return arts;
	}
		
	
}
	
		
		
		
		
		
	