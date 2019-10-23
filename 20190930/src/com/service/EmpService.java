package com.service;

import java.util.List;

import com.dao.EmpDao;
import com.pojo.Emp;

public class EmpService {
	private EmpDao ed = new EmpDao();
	
	public List<Emp> getEmpsByName(String ename){
		return ed.getEmpsByName(ename);
	}
}
