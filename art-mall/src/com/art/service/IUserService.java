package com.art.service;

import com.art.pojo.User;

public interface IUserService {
	
	 public int checkLogin(String user_name, String user_password);
	 
	 public boolean addUser(User user);

}
