package com.question.pojo;

public class Question {
	private int id;
	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private int level;
	private String author;
	private QuestionType type;
	
	
	public Question(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAns1() {
		return ans1;
	}

	public void setAns1(String ans1) {
		this.ans1 = ans1;
	}

	public String getAns2() {
		return ans2;
	}

	public void setAns2(String ans2) {
		this.ans2 = ans2;
	}

	public String getAns3() {
		return ans3;
	}

	public void setAns3(String ans3) {
		this.ans3 = ans3;
	}

	public String getAns4() {
		return ans4;
	}

	public void setAns4(String ans4) {
		this.ans4 = ans4;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", ans1=" + ans1 + ", ans2=" + ans2 + ", ans3=" + ans3
				+ ", ans4=" + ans4 + ", level=" + level + ", author=" + author + ", type=" + type + "]";
	}
	
	
}
