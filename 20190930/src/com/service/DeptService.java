package com.service;

import com.dao.DeptDao;
import com.pojo.Dept;

public class DeptService {
	private DeptDao dd = new DeptDao();
	
	public boolean saveDept(Dept dept) {
		Dept d = dd.getDeptByNo(dept.getDeptno());
		if(d==null) {
			int rs = dd.addDept(dept);
			if(rs > 0) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
}
