package com.iphone.system.service;

import com.iphone.system.pojo.Page;

public interface IUserService {
	public Page getUserByPage(int size,int pageno);
}
