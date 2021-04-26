package com.example.login.SelectController;

import com.alibaba.fastjson.JSON;
import com.example.annotation.PassToken;
import com.example.annotation.UserLoginToken;
import com.example.constant.LoginConstant;
import com.example.login.SelectDao.SelLoginDao;
import com.example.login.pojo.LoginUserDTO;
import com.example.login.pojo.User;
import com.example.login.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SelLoginController {

    @Autowired
    SelLoginDao selLoginDao;



    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @UserLoginToken
    public LoginUserDTO LoginController(@RequestBody User user){
          System.out.println("进入controller");
          System.out.println("我是controller32");

        User user1 = selLoginDao.SelectUserById(user);
        if(user1!=null){
            String token = JwtUtil.getToken(user1);
            Integer userId = JwtUtil.getUserId(token);
            LoginConstant.loginTokens.put(userId,token);
            LoginUserDTO loginUserDTO = new LoginUserDTO();
            loginUserDTO.setName(user1.getUsername());
            loginUserDTO.setToken(token);
            loginUserDTO.setCode("200");
            return loginUserDTO;
        }else{
            LoginUserDTO loginUserDTO = new LoginUserDTO();
            loginUserDTO.setCode("404");
            return loginUserDTO;
        }

    }



}
