package com.inc.vo;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	@Pattern(regexp="[A-Za-z0-9] {4,10}", message="아이디는 영대소문자, 숫자의 조합으로 4~10글자 이내로만 가능합니다.")
	private String id;
	@Size(min=2, max=5, message="이름은 2글자 이상 5글자 이하로 작성해야 합니다.")
	private String name;
	private String password;
	private String email;
	//@NotEmpty : 공백까지 제외
	@NotEmpty(message="직업 대분류를 선택하세요.")
	private String bjob;
	@NotEmpty(message="직업 소분류를 선택하세요.")
	private String sjob;
	
	public UserVo(String id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}
	
	public UserVo() {
		
	}

	public UserVo(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}
	
	public String getBjob() {
		return bjob;
	}

	public void setBjob(String bjob) {
		this.bjob = bjob;
	}

	public String getSjob() {
		return sjob;
	}

	public void setSjob(String sjob) {
		this.sjob = sjob;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	
}
