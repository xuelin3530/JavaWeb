package com.art.dao;

import java.util.List;

import com.art.pojo.Art;

public interface IArtDao {
	public int addArt(Art art);
	public List<Art> getAllArts();
	
	public int updateArt(Art art);
	public int deleteArt(int id);
	//通过ID获取Art的方法
	public Art getArtById(int id);
	
	//根据当前页码和每页个数，返回该页记录
	public List<Art> getArtsByPage(int size, int pageno);
}
