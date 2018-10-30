package com.green.common.core.redis;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;


public class RedisCache<K, V> implements Cache<K, V> {

    private String cacheKey;
    private RedisTemplate<K, V> redisTemplate;

    @SuppressWarnings("rawtypes")
    public RedisCache(String name, RedisTemplate client) {
        this.cacheKey = RedisShiroUtil.REDIS_SHIRO_CACHE ;
        this.redisTemplate = client;
    }


    @Override
    public V get(K key) throws CacheException {
        redisTemplate.boundValueOps(getCacheKey(key)).expire(RedisShiroUtil.globExpire, TimeUnit.MINUTES);
        return redisTemplate.opsForValue().get(getCacheKey(key));
    }

    @Override
    public V put(K key, V value) throws CacheException {
        redisTemplate.opsForValue().set(getCacheKey(key),value);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        V old = get(getCacheKey(key));
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    private K getCacheKey(Object k) {
        return (K) (this.cacheKey + k);
    }
}
