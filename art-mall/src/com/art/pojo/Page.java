package com.art.pojo;
import java.util.List;
public class Page {
	//每页记录的个数
	private int size = 6;
	//当前页码
	private int pageno = 1;	
	//总页数
	private int totalPage;
	//总记录数
	private int totalRecord;
	//当页数据
	private List list;
	
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
	
	public Page() {}
	
	public Page(int size, int pageno) {
		super();
		this.size = size;
		this.pageno = pageno;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
			
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public int getTotalPage() {
		return totalPage;
	}

	
	public void settotalPage() {
		this.totalPage = totalRecord / size;
		if(totalRecord % size !=0) {
			this.totalPage++;
		}
	}


	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
}
