package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletContextListener {
    //write your code here!
    public void contextInitialized(ServletContextEvent sce){
        LocalDateTime servletTimeInit = java.time.LocalDateTime.now();
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("servletTimeInit", servletTimeInit);
    }
}
