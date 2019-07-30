package com.wjx.shiro.shiro.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wjx.shiro.shiro.domain.User;
import com.wjx.shiro.shiro.mapper.UserMapper;
import com.wjx.shiro.shiro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public User getUserByName(String name) {
		return userMapper.getUserByName(name);
	}

	@Override
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

}
