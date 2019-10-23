package service;

import java.util.List;

import dao.UserDao;
import pojo.User;

public class UserService {
//	创建Service的私有属性和Dao调用
	private UserDao ud = new UserDao();
//	last-> 调用Dao方法
	public List<User> getAllUsers(){
//		打包给servlet
		return ud.getAllUser();
	}
//	登录是否成功由service决定，所以在此定义boolean类型的方法
	public boolean checkLogin(String lname, String lpwd) {
//		假设不成功
		boolean rs = false;
//		调用Dao中方法
		User user = ud.getUserByName(lname);
		if(user != null) {
//			判断
			if(user.getUsername().equals(lname) && user.getPassword().equals(lpwd)) {
				rs = true;
			}
		}		
		return rs;
	}
//	方法二返回int类型，判断两种错误：用户名不存在/密码错误
	public int checkLogin2(String lname, String lpwd) {
		int rs = 0;//登录失败
		
		User user = ud.getUserByName(lname);
		if(user != null) {
			if(user.getUsername().equals(lname) && user.getPassword().equals(lpwd)) {
				rs = 1;//登陆成功
			}else {
				rs = 2;//用户名密码错误
			}
		}else {
			rs = 3;//当前用户名不存在
		}		
		return rs;
	}
	
	
}
