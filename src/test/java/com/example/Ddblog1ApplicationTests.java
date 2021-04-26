package com.example;

import com.example.markdown.bean.MarkDown;
import com.example.markdown.service.impl.SelServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Ddblog1ApplicationTests {
    @Autowired
    SelServiceImpl selectMarkDownService;
    @Test
    void contextLoads() {
        long l = System.currentTimeMillis();
        for(MarkDown m:selectMarkDownService.selBlogByPage(0)){
            System.out.println(m.getId());
        }
        System.out.println(System.currentTimeMillis()-l);
    }

}
