package com.inc.vo;

import org.springframework.web.multipart.MultipartFile;

public class ProductVo {

	private int id, price;
	private double retail_pct;
	private String category, model, manufacturer, image_s, 
	image_l, content, regdate;
	private MultipartFile image_l_file;
	private MultipartFile image_s_file;
	
	public MultipartFile getImage_l_file() {
		return image_l_file;
	}
	public void setImage_l_file(MultipartFile image_l_file) {
		this.image_l_file = image_l_file;
	}
	public MultipartFile getImage_s_file() {
		return image_s_file;
	}
	public void setImage_s_file(MultipartFile image_s_file) {
		this.image_s_file = image_s_file;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getRetail_pct() {
		return retail_pct;
	}
	public void setRetail_pct(double retail_pct) {
		this.retail_pct = retail_pct;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getImage_s() {
		return image_s;
	}
	public void setImage_s(String image_s) {
		this.image_s = image_s;
	}
	public String getImage_l() {
		return image_l;
	}
	public void setImage_l(String image_l) {
		this.image_l = image_l;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
