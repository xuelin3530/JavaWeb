package com.phone1000.system.dao;
import java.util.List;

import com.phone1000.system.pojo.User;

public interface IUserDao {
	
	//根据当前页码和每页个数，返回该页记录
	public List<User> getUsersByPage(int size, int pageno);
	//查询表中全部记录
	public List<User> getAllUsers();
}
