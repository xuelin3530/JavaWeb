package com.phone1000.system.service;

import com.phone1000.system.pojo.Page;

public interface IUserService {
	public Page getUsersByPage(int size, int pageno);
}
