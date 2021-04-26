package com.example.config;

import com.example.filter.LoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class WendaWebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    LoginFilter loginFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginFilter);
        super.addInterceptors(registry);
    }
}

