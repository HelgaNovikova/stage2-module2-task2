package com.example.servlet;

import com.example.Users;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //write your code here!

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("user");
        try {
            session.getAttribute("user");
            resp.sendRedirect(req.getContextPath() + "/user/hello.jsp");
        } catch (Exception e) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        if ((password.length() !=0) && (Users.getInstance().getUsers().contains(login))){
            session.setAttribute("user", "user");
            resp.sendRedirect(req.getContextPath() + "/user/hello.jsp");
        }
        else {
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }

    }
}
