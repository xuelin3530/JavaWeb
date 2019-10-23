package com.art.dao;

import com.art.pojo.Admin;

public interface IAdminDao {
	
	//根据登录名获取Admin对象的方法
	public Admin getAdminByName(String admin);


}
