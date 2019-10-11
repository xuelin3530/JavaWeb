package com.pojo;

public class Employee {
	private int id;
	private String name;
	private String sex;
	private Integer age;
	private String depart;
	private Integer year;
	private Post post;
	
	public Employee() {
		this.post = new Post();
	}

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + ", age=" + age + ", depart=" + depart
				+ ", year=" + year + ", post=" + post + "]";
	}
	
	
}
