package com.wjx.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class UserController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello";
	}

	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		model.addAttribute("name", "wangjx");
		return "test";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "/user/add";
	}

	@RequestMapping("/update")
	public String update() {
		return "/user/update";
	}
	
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("/unauth")
	public String unauth() {
		return "unauth";
	}
	
	@RequestMapping("/login")
	public String login(Model model, String name, String password) {
		log.info("login " + name + " " + password);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name, password);
		try {
			subject.login(token);
			return "redirect:thymeleaf";
		} catch (UnknownAccountException ex) {
			model.addAttribute("msg", "login err name");
			log.error("err ", ex);
			return "/login";
		}catch (IncorrectCredentialsException ex) { 
			model.addAttribute("msg", "login err password");
			log.error("err ", ex);
			return "/login";
		}catch (AuthenticationException ex) { 
			model.addAttribute("msg", "login err password");
			log.error("err ", ex);
			return "/login";
		}
	}


}
