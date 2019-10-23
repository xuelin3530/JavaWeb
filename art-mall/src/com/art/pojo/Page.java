package com.art.pojo;
import java.util.List;
public class Page {
		private int size = 3;
		private int pageno = 1;
		private int totalPage;
		private int totalRecord;
		private List list;
		
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
			int pages = this.totalRecord % this.size !=0 ? (this.totalRecord / this.size +1 ) :(this.totalRecord / this.size);
			this.setTotalPage(pages);
			
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

		private void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}

		public int getTotalRecord() {
			return totalRecord;
		}

		public void setTotalRecord(int totalRecord) {
			this.totalRecord = totalRecord;
			int pages = this.totalRecord % this.size !=0 ? (this.totalRecord / this.size +1 ) :(this.totalRecord / this.size);
			this.setTotalPage(pages);
		}

		public List getList() {
			return list;
		}

		public void setList(List list) {
			this.list = list;
		}
		
		
}
