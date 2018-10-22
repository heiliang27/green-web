package com.green.modular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate; 

	@RequestMapping("/login")
	public String login(){
		redisTemplate.opsForValue().set("lml", "limingliang250"); 
		return "login.html";
	}
}
