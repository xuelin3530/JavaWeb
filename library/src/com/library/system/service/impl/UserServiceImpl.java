package com.library.system.service.impl;

import com.library.system.dao.IUserDao;
import com.library.system.dao.impl.UserDaoImpl;
import com.library.system.pojo.User;
import com.library.system.service.IUserService;

public class UserServiceImpl implements IUserService{ 
	
	private IUserDao ud = new UserDaoImpl();

	@Override
	public String login(User u) {
		
		return ud.login(u);
		
	}

	
}
