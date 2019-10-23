package com.service.impl;

import java.util.List;

import com.dao.IUserDao;
import com.dao.impl.UserDaoImpl;
import com.pojo.User;
import com.service.IUserService;

public class UserServiceImpl implements IUserService, IUserDao {
	private IUserDao ud = new UserDaoImpl();
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return ud.getAllUsers();
	}

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return ud.addUser(user);
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return ud.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return ud.deleteUser(id);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return ud.getUserById(id);
	}

	@Override
	public List<User> getUsersByDepa(String depa) {
		// TODO Auto-generated method stub
		return ud.getUsersByDepa(depa);
	}

	@Override
	public List<User> getUsersByName(String name) {
		// TODO Auto-generated method stub
		return ud.getUsersByName(name);
	}

}
