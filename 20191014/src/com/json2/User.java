package com.json2;

import java.util.List;

public class User {
	private String name;
	private int age;
	private List<Book> list;
	
	public User() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", list=" + list + "]";
	}
	
	
}
