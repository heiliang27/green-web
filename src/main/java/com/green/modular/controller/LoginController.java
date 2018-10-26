package com.green.modular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
public class LoginController {
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	
	@Autowired
	JedisPool jedisPool;

	@RequestMapping("/login")
	public String login(){	
		Jedis jedis = jedisPool.getResource();
		System.out.println(redisTemplate.opsForValue().get("lml"));
		System.out.println("jedis="+jedis.get("lml"));
		return "login.html";
	}
}
