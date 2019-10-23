package test.service;

import java.util.List;

import test.dao.UserDao;
import test.pojo.User;

public class UserService {
 
	private UserDao ud = new UserDao();
	
	public List<User> getAllUsers(){
		return ud.getAllUser();
	}
	
	public boolean checkLogin(String lname, String lpwd) {
		boolean rs = false;
		
		User user = ud.getUserByName(lname);
		if(user != null) {
			if(user.getUsername().equals(lname) && user.getPassword().equals(lpwd)) {
				rs = true;
			}
		}		
		return rs;
	}
	
	public int checkLogin2(String lname, String lpwd) {
		int rs = 0;
		
		User user = ud.getUserByName(lname);
		if(user != null) {
			if(user.getUsername().equals(lname) && user.getPassword().equals(lpwd)) {
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
