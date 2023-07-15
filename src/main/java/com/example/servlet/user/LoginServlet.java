package com.example.servlet.user;

import com.example.pojo.Users;
import com.example.service.user.UserService;
import com.example.service.user.UserServiceImpl;
import com.example.util.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    // Connect to the service layer
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get inputted username and password
        String username = req.getParameter("userCode");
        String password = req.getParameter("userPassword");

        // Take related information from the service layer
        UserService userService = new UserServiceImpl();
        Users user = userService.login(username, password);

        if(user != null){
            HttpSession session = req.getSession(true);
            session.setAttribute(Constant.userSession,user);
            resp.sendRedirect("static/jsp/frame.jsp");
        }else {
            req.setAttribute("error","Incorrect username or password...");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
