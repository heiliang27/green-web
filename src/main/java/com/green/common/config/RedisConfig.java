package com.green.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import com.green.common.config.properties.RedisProperties;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

	@Autowired
	private RedisProperties redisProperties;

	/** JedisPoolConfig 连接池配置 */
	@Bean
	public JedisPoolConfig jedisPoolConfig() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		redisProperties.jedisPoolConfig(jedisPoolConfig);
		System.out.println("jedisPoolConfig--初始化----------------------------");
		return jedisPoolConfig;
	}

	/** JedisPool连接池 */
	@Bean
	public JedisPool jedisPool() {
		JedisPool jedisPool = redisProperties.jedisPool(jedisPoolConfig());
		System.out.println("jedisPool--初始化----------------------------");
		return jedisPool;
	}
}
