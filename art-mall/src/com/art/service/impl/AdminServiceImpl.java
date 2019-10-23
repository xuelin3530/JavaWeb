package com.art.service.impl;

import com.art.dao.impl.AdminDaoImpl;
import com.art.pojo.Admin;
import com.art.service.IAdminService;

public class AdminServiceImpl implements IAdminService{
	
	private AdminDaoImpl adi = new AdminDaoImpl();

	@Override
	public int checkLogin(String admin_name, String admin_password) {
		
		int rs = 0;
		
		Admin admin = adi.getAdminByName(admin_name);
		
		if(admin !=null) {
			if (admin.getAdmin_name().equals(admin_name)&&admin.getAdmin_password().equals(admin_password)) {
				rs = 1;
			}else {
				rs = 2;
			}
		}else {
			rs = 3;
		}
		return rs;
	}


}
