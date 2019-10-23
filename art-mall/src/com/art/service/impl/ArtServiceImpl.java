package com.art.service.impl;

import java.util.List;

import com.art.dao.IArtDao;
import com.art.dao.impl.ArtDaoImpl;
import com.art.pojo.Art;
import com.art.pojo.Page;
import com.art.service.IArtService;

public class ArtServiceImpl implements IArtService{
	
	private IArtDao iad = new ArtDaoImpl();
		
	@Override
	public boolean addArt(Art art) {
		
		int rs = iad.addArt(art);

		return rs > 0;
		
	}

	@Override
	public List<Art> getAllArts() {
		// TODO Auto-generated method stub
		return iad.getAllArts();
	}

	@Override
	public int updateArt(Art art) {
		// TODO Auto-generated method stub
		return iad.updateArt(art);
	}

	@Override
	public int deleteArt(int id) {
		// TODO Auto-generated method stub
		return iad.deleteArt(id);
	}

	@Override
	public Art getArtById(int id) {
		// TODO Auto-generated method stub
		return iad.getArtById(id);
	}

	@Override
	public Page getArtsByPage(int size, int pageno) {
		Page page = new Page(size, pageno);
		page.setList(iad.getArtsByPage(size, pageno));
		page.setTotalRecord(iad.getAllArts().size());
				
		return page;
	}

}
