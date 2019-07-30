package com.wjx.shiro.shiro.domain;

public class User {

	private int id;
	private String nane;
	private String password;
	private String perms;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNane() {
		return nane;
	}

	public void setNane(String nane) {
		this.nane = nane;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms;
	}

}
