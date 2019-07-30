package com.wjx.shiro.shiro.service;

import com.wjx.shiro.shiro.domain.User;

public interface UserService {
	
	public User getUserByName(String name);
	
	public User getUserById(Integer id);

}
