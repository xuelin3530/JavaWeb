package com.art.service.impl;

import com.art.dao.impl.UserDaoImpl;
import com.art.pojo.User;
import com.art.service.IUserService;

public class UserServiceImpl implements IUserService{
	
	private UserDaoImpl usi = new UserDaoImpl();

	@Override
	public int checkLogin(String user_name,String user_password) {

		int rs = 0;
		
		User user = usi.getUserByName(user_name);
		
		if(user !=null) {
			if (user.getUser_name().equals(user_name)&&user.getUser_password().equals(user_password)) {
				rs = 1;
			}else {
				rs = 2;
			}
		}else {
			rs = 3;
		}
		return rs;
	}

	@Override
	public boolean addUser(User user) {
		
		int rs = usi.addUser(user);
		
		return rs>0;
		

	}

}
