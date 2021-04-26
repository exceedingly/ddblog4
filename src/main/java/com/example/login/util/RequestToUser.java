package com.example.login.util;

import com.alibaba.fastjson.JSON;
import com.example.login.pojo.User;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public class RequestToUser {
    public static User  getUser(HttpServletRequest request) throws IOException {
        byte[] bodyBytes = StreamUtils.copyToByteArray(request.getInputStream());
        String body = new String(bodyBytes, request.getCharacterEncoding());
        Map parse = (Map) JSON.parse(body);
        User user = new User();
        user.setUsername(String.valueOf(parse.get("username")));
        user.setPassword(String.valueOf(parse.get("password")));
        return user;
    }
}
