package com.art.service;

import java.util.List;

import com.art.pojo.Art;
import com.art.pojo.Page;

public interface IArtService {
	public boolean addArt(Art art);
	public List<Art> getAllArts();
	public int updateArt(Art art);
	public int deleteArt(int id);
	
	public Art getArtById(int id);
	

	public Page getArtsByPage(int size, int pageno);
}
