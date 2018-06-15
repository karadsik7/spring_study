package com.inc.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProductVo {

	private int id;
	@NotNull(message="수량을 입력해주세요.")
	private Integer count;
	@Pattern(regexp="[가-힣]{2,5}", message="2~5글자의 한글") //varchar2(15)
	private String name;
	private String regdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
