package com.json;

import java.util.ArrayList;
import java.util.List;

public class Boy {
	private String name;
	private int age;
	private List<String> girlFreind;
	
	public Boy() {
		girlFreind = new ArrayList<String>();
	}

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

	public List<String> getGirlFreind() {
		return girlFreind;
	}

	public void setGirlFreind(List<String> girlFreind) {
		this.girlFreind = girlFreind;
	}

	@Override
	public String toString() {
		return "Boy [name=" + name + ", age=" + age + ", girlFreind=" + girlFreind + "]";
	}
	
	
	
}
