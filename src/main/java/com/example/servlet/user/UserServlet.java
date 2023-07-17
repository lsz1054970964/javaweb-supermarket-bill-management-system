package com.example.servlet.user;

import com.alibaba.fastjson2.JSONArray;
import com.example.pojo.Users;
import com.example.service.user.UserService;
import com.example.service.user.UserServiceImpl;
import com.example.util.Constant;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("savepwd") && method!=null){
            this.updatePassword(req,resp);
        } else if (method.equals("pwdmodify") && method!=null) {
            this.verifyPassword(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    // Update password
    public void updatePassword(HttpServletRequest req, HttpServletResponse resp) {
        Object user = req.getSession().getAttribute(Constant.userSession);

        String newPassword = req.getParameter("newpassword");

        boolean flag = false;

        if(user!=null && !StringUtils.isNullOrEmpty(newPassword)){
            UserService userService = new UserServiceImpl();
            flag = userService.updatePassword(((Users) user).getId(),newPassword);

            if(flag){
                req.getSession().setAttribute("message","Update successfully!");
                req.getSession().removeAttribute(Constant.userSession);
            } else {
                req.getSession().setAttribute("message","Updating failed...");
            }
        } else {
            req.getSession().setAttribute("message","Invalid new password");
        }
        try {
            req.getRequestDispatcher("/static/jsp/pwdmodify.jsp").forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Verify old password
    public void verifyPassword(HttpServletRequest req, HttpServletResponse resp){
        Object user = req.getSession().getAttribute(Constant.userSession);

        String oldPassword = req.getParameter("oldpassword");

        Map<String, String> map = new HashMap<String, String>();

        if(user==null){
            // Session gets expired
            map.put("result","sessionerror");
        } else if (StringUtils.isNullOrEmpty(oldPassword)) {
            // no inputted old password
            map.put("result","error");
        } else {
            // user password from database
            String userPassword = ((Users) user).getUserPassword();
            if(oldPassword.equals(userPassword)){
                map.put("result","true");
            } else {
                map.put("result","false");
            }
        }

        resp.setContentType("application/json");
        try {
            PrintWriter writer = resp.getWriter();
            writer.write(JSONArray.toJSONString(map));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
