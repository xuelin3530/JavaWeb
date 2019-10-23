package com.service;

import java.util.List;

import com.dao.EmployeeDao;
import com.pojo.Employee;

public class EmployeeService {
	private EmployeeDao ed = new EmployeeDao();
	
	public List<Employee> getEmpsByNameOrPost(Employee emp){
		return ed.getEmpsByNameOrPost(emp);
	}
}
