package com.green.modular.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
public class LoginController {
	
	@Autowired
	private JedisPool jedisPool;
	

	@RequestMapping("/login")
	public String login(){
		Jedis jedis = jedisPool.getResource();
		jedis.set("lml", "limingliang"+new Random().nextInt(1000));		
		System.out.println("---------redis----"+jedis.get("lml"));
		System.out.println("---------redis----"+jedis.get("use"));
		return "login.html";
	}
}
