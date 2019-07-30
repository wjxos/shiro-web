package com.wjx.shiro.shiro.mapper;

import org.apache.ibatis.annotations.Param;

import com.wjx.shiro.shiro.domain.User;

public interface UserMapper {

	public User getUserByName(@Param("name") String name);
	
	public User getUserById(@Param("id") Integer name);

}
