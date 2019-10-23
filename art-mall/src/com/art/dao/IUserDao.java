package com.art.dao;

import com.art.pojo.User;

public interface IUserDao {
	
	public User getUserByName(String User);
//	public boolean registerUser(String User);
	
//	添加用户
	 int addUser(User user);
}
