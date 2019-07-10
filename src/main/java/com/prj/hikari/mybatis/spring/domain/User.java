package com.prj.hikari.mybatis.spring.domain;

import org.apache.ibatis.annotations.Select;

//	@Select("select id, name, email from users")
public class User {

	private Integer id;
	private String name;
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"name\":\"" + name + "\", \"email\":\"" + email + "\" }";
	}
}
