package com.iphone.system.pojo;

public class User {
	private int id;
	private String uname;
	private String sex;
	private String tel;
	private String depa;
	
	public User() {}

	public User(String uname, String sex, String tel, String depa) {
		super();
		this.uname = uname;
		this.sex = sex;
		this.tel = tel;
		this.depa = depa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getDepa() {
		return depa;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", uname=" + uname + ", sex=" + sex + ", tel=" + tel + ", depa=" + depa + "]";
	}

	public void setDepa(String depa) {
		this.depa = depa;
	}
	
	
	
}
