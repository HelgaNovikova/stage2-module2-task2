package com.example.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        if (((HttpServletRequest) req).getRequestURI().contains("/user/")){
            try{
                request.getSession().getAttribute("user");
                chain.doFilter(req, res);
            } catch (Exception e){
                response.sendRedirect(request.getContextPath() + "/login.jsp");
            }
        }
    }
    //write your code here!
}