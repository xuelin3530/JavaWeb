package com.json2;

public class Book {
	private double price;
	private String bookName;
	
	public Book() {}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	@Override
	public String toString() {
		return "Book [price=" + price + ", bookName=" + bookName + "]";
	}
	
	
}
