package com.example.TestMarkDown;

import com.example.login.pojo.User;
import com.example.login.util.JwtUtil;
import com.example.markdown.dao.SelDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class TestController {
    @Autowired
    SelDao selDao;
    @Test
    void fun() {
        System.out.println(selDao.selImagesPath());
    }
}
