package com.phone1000.system.service.impl;

import com.phone1000.system.dao.IUserDao;
import com.phone1000.system.dao.impl.UserDaoImpl;
import com.phone1000.system.pojo.Page;
import com.phone1000.system.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao ud = new UserDaoImpl();
	@Override
	public Page getUsersByPage(int size, int pageno) {
		Page page = new Page(size, pageno);
		page.setList(ud.getUsersByPage(size, pageno));
		page.setTotalRecord(ud.getAllUsers().size());
				
		return page;
	}

}
