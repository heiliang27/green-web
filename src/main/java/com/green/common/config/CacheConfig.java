package com.green.common.config;

import java.lang.reflect.Method;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import com.green.common.core.redis.RedisCacheManager;

@Configuration
public class CacheConfig {
	
	@Bean
	public RedisCacheManager cacheManager(RedisTemplate redisTemplate){
		RedisCacheManager cacheManager = new RedisCacheManager();
		cacheManager.setRedisTemplate(redisTemplate);
		return cacheManager;
	}

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			public Object generate(Object target, Method method, Object... objects) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}
}
