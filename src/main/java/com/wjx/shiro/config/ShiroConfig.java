package com.wjx.shiro.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wjx.shiro.shiro.UserRealm;

@Configuration
public class ShiroConfig {
	
	/**
	 * ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		/**
		 * anon
		 * authc
		 * user
		 * perms
		 * role
		 */
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
//		filterMap.put("/add", "authc");
//		filterMap.put("/update", "authc");
		filterMap.put("/thymeleaf", "anon");
		filterMap.put("/login", "anon");
		
		filterMap.put("/add", "perms[user:add]");
		filterMap.put("/update", "perms[user:update]");
		
		filterMap.put("/*", "authc");

		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		
		shiroFilterFactoryBean.setLoginUrl("/toLogin");
		shiroFilterFactoryBean.setUnauthorizedUrl("unauth");
		
		return shiroFilterFactoryBean;
	}
	
	/**
	 * DefaultWebSecurityManager
	 */
	@Bean("securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	
	/**
	 * 创建realml
	 */
	@Bean("userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
	
	/*
	 * @Bean public ShiroDialect getShiroDialect() { return new ShiroDialect(); }
	 */
}
