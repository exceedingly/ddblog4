package com.example.filter;

import com.example.annotation.PassToken;
import com.example.annotation.UserLoginToken;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
@Component
public class LoginFilter extends HandlerInterceptorAdapter {
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
            System.out.println("password 放行");
            return true;
//            PassToken passToken = method.getAnnotation(PassToken.class);
//            if (passToken.required()) {
//                System.out.println("注解 放行");
//                return true;
//            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
                return true ;
        }else{
            String token = request.getHeader("token");
            if(token!=null && !token.equals("null") ){
                return true;
            }else{
                //除了登录 之外的所有请求
                System.out.println("没有携带token");
                return false;
            }
        }
   }
}
