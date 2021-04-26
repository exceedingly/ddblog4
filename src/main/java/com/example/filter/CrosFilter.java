package com.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrosFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Methods", "*");
       // res.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token");//这里“Access-Token”是我要传到后台的内容key
        res.setHeader("Access-Control-Allow-Headers", "*");//这里“Access-Token”是我要传到后台的内容key
        res.setHeader("Access-Control-Expose-Headers", "*");
       // res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, timestamp ,token");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}