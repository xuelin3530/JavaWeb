package com.question.pojo;

public class QuestionType {
	private int tid;
	private String tname;
	
	public QuestionType() {}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public String toString() {
		return "QuestionType [tid=" + tid + ", tname=" + tname + "]";
	}
	
	
}
