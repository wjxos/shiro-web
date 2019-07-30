package com.wjx.shiro.shiro;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import com.wjx.shiro.shiro.domain.User;
import com.wjx.shiro.shiro.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRealm extends AuthorizingRealm{
	
	@Resource
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("执行授权逻辑");
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//info.addStringPermission("user:add");
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		User dbUser = userService.getUserById(user.getId());
		info.addStringPermission(dbUser.getPerms());
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken args) throws AuthenticationException {
		log.info("执行认证逻辑");
		
		UsernamePasswordToken token = (UsernamePasswordToken)args;
		User user = userService.getUserByName(token.getUsername());
		
		
		if(null == user) {
			return null;
		}
	    return new SimpleAuthenticationInfo(user, user.getPassword(), "");
	}

}
