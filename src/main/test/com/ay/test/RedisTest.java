package com.ay.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends BaseJunit4Test {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedis() {
        redisTemplate.opsForValue().set("name", "wang");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
    }
}
