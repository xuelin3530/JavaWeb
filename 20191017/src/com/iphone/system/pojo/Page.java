package com.iphone.system.pojo;

import java.util.List;

public class Page {
	//每页记录的个数
	private int size = 5;
	//当前页码
	private int pageno = 1;
	//	总页数
	private int totalpage;
	 //	总记录数
	private int totalRecord;
	//	当页数据
	private List list;
	
	public Page() {
				
	}
	

	public Page(int size, int pageno) {
		super();
		this.size = size;
		this.pageno = pageno;
	}



	public int getSize() {
		return size;
	}

	//计算总页数
	public void setSize(int size) {
		this.size = size;
		int pages = this.totalRecord%this.size!=0?(this.totalRecord/this.size+1):(this.totalRecord/this.size+1);
		//有pages以后，调用一下方法，把pages
		this.setTotalpage(pages);
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public int getTotalpage() {
		return totalpage;
	}

	//总页数取决于每页的大小，我们需要计算，顾此处改为私有
	private void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		int pages = this.totalRecord%this.size!=0?(this.totalRecord/this.size+1):(this.totalRecord/this.size+1);
		//有pages以后，调用一下方法，把pages
		this.setTotalpage(pages);
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	

}
