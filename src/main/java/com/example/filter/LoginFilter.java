package com.example.filter;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.annotation.PassToken;
import com.example.annotation.UserLoginToken;
import com.example.constant.LoginConstant;
import com.example.login.SelectDao.SelLoginDao;
import com.example.login.pojo.User;
import com.example.login.util.JwtUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.*;

@Component
public class LoginFilter extends HandlerInterceptorAdapter {
    private HashMap<Integer,String> maps = new HashMap<>();

    @Autowired
    SelLoginDao selLoginDao;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        // 如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod=(HandlerMethod)handler;
        Method method=handlerMethod.getMethod();
//        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                System.out.println("注解 放行");
                return true;
            }
        }

//

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
//            System.out.println("登陆注解");
                return true ;
//            User user = new User();
//            user.setUsername("admin");
//            user.setPassword("123456");
//            User user1 = selLoginDao.SelectUserById(user);
//            if(user1==null){
//                // 数据库没有
//                System.out.println("数据库没有");
//                return false;
//            }else{
////                String token = JwtUtil.getToken(user1);
////                maps.put(JwtUtil.getUserId(token),token);
////                System.out.println(maps);
////                response.setHeader("token",token);
//                System.out.println("登陆放行");
//                return true;
//            }
        }else{
            String token = request.getHeader("token");
            System.out.println(token);
            System.out.println("null".equals(token));
            if(token!=null && !token.equals("null") ){
                System.out.println("携带tonken        "+token);
                return true;
            }else{
                //除了登录 之外的所有请求
                System.out.println("没有携带token");
                return false;
            }
        }
   }
}
