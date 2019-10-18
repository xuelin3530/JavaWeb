package com.iphone.system.service.impl;

import com.iphone.system.dao.IUserDao;
import com.iphone.system.dao.impl.UserDaoImpl;
import com.iphone.system.pojo.Page;
import com.iphone.system.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao ud = new UserDaoImpl();
	@Override
	public Page getUserByPage(int size, int pageno) {
		Page page = new Page(size,pageno);
		page.setList(ud.getUsersByPage(size, pageno));
		page.setTotalRecord(ud.getAllUsers().size());

		
		return page;
	}

}
