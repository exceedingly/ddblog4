package com.example.TestMarkDown;
import com.example.login.SelectDao.SelLoginDao;
import com.example.login.pojo.User;
import com.example.login.util.JwtUtil;
import com.example.markdown.bean.MarkDown;
import com.example.markdown.bean.TagPO;
import com.example.markdown.dao.InsDao;
import com.example.markdown.dao.SelDao;

import com.example.markdown.dao.UpdateDao;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;
    @Test
    void fun() {
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("123456");
        String token = JwtUtil.getToken(user);
        System.out.println(token);

        redisTemplate.opsForValue().set("as","asa");
        System.out.println(redisTemplate.opsForValue().get("assas"));
    }
}
