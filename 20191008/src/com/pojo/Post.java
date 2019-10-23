package com.pojo;

public class Post {
	private int id;
	private String name;
	private String desc;
	
	public Post() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}
	
	
	
	
}
