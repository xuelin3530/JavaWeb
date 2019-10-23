package com.art.pojo;

public class Art {
	private int art_id;
	private String art_name;
	private String art_price;
	private String art_introduction;
	private String art_detail;
	private String art_cover;
	
	public Art() {}

	public Art(int art_id, String art_name, String art_price, String art_introduction, String art_detail,
			String art_cover) {
		super();
		this.art_id = art_id;
		this.art_name = art_name;
		this.art_price = art_price;
		this.art_introduction = art_introduction;
		this.art_detail = art_detail;
		this.art_cover = art_cover;
	}

	public int getArt_id() {
		return art_id;
	}

	public void setArt_id(int art_id) {
		this.art_id = art_id;
	}

	public String getArt_name() {
		return art_name;
	}

	public void setArt_name(String art_name) {
		this.art_name = art_name;
	}

	public String getArt_price() {
		return art_price;
	}

	public void setArt_price(String art_price) {
		this.art_price = art_price;
	}

	public String getArt_introduction() {
		return art_introduction;
	}

	public void setArt_introduction(String art_introduction) {
		this.art_introduction = art_introduction;
	}

	public String getArt_detail() {
		return art_detail;
	}

	public void setArt_detail(String art_detail) {
		this.art_detail = art_detail;
	}

	public String getArt_cover() {
		return art_cover;
	}

	public void setArt_cover(String art_cover) {
		this.art_cover = art_cover;
	}

	@Override
	public String toString() {
		return "Art [art_id=" + art_id + ", art_name=" + art_name + ", art_price=" + art_price + ", art_introduction="
				+ art_introduction + ", art_detail=" + art_detail + ", art_cover=" + art_cover + "]";
	}

	
	
}
