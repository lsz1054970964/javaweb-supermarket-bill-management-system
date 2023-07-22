package com.example.servlet.user;

import com.alibaba.fastjson2.JSONArray;
import com.example.pojo.Roles;
import com.example.pojo.Users;
import com.example.service.role.RoleServiceImpl;
import com.example.service.user.UserService;
import com.example.service.user.UserServiceImpl;
import com.example.util.Constant;
import com.example.util.PageSupport;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if(method.equals("savepwd") ){
            this.updatePassword(req,resp);
        } else if (method.equals("pwdmodify") ) {
            this.verifyPassword(req,resp);
        } else if(method.equals("query")) {
            this.checkUser(req,resp);
        } else if(method.equals("add")){
            this.addUser(req,resp);
        } else if (method.equals("ucexist")) {
            this.verifyUser(req, resp);
        } else if (method.equals("deluser")){
            this.deleteUser(req, resp);
        } else if (method.equals("modifyexe")){
            this.updateUser(req, resp);
        } else if (method.equals("view")){
            this.viewUser(req, resp);
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

    // Load user list
    public void checkUser(HttpServletRequest request, HttpServletResponse response){

        // Get parameters from the front end
        String queryName = request.getParameter("queryname");
        String queryUserRole = request.getParameter("queryUserRole");
        String queryUserPage = request.getParameter("pageIndex");

        // Default role
        int queryRole = 0;

        // Get userList
        UserServiceImpl userService = new UserServiceImpl();
        //Default page index and size
        int queryPage = 1;
        int querySize = 5;

        if(queryName == null){
            queryName = "";
        }

        if(queryUserRole!=null && !queryUserRole.equals("")){
            queryRole = Integer.parseInt(queryUserRole);
        }

        if(queryUserPage != null){
            queryPage = Integer.parseInt(queryUserPage);
        }

        // Get user count
        int totalCount = userService.getUserCount(queryName, queryRole);
        // Total page count
        PageSupport pageSupport = new PageSupport();
        pageSupport.setPageSize(querySize);
        pageSupport.setCurrentPageNo(queryPage);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount = pageSupport.getTotalPageCount();

        // For first and last pages
        if(queryPage < 1){
            queryPage = 1;
        } else if (queryPage > totalPageCount) {
            queryPage = totalPageCount;
        }

        // Get user list and put it to front end
        List<Users> usersList = userService.getUserList(queryName, queryRole, queryPage, querySize);
        request.setAttribute("userList", usersList);

        // Get role list and put it to front end
        RoleServiceImpl roleService = new RoleServiceImpl();
        List<Roles> rolesList = roleService.getRoleList();
        request.setAttribute("roleList", rolesList);

        // Put parameters to front end
        request.setAttribute("totalCount", totalCount);
        request.setAttribute("currentPageNo", queryPage);
        request.setAttribute("totalPageCount", totalPageCount);

        try {
            request.getRequestDispatcher("/static/jsp/userlist.jsp").forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Add user
    public void addUser(HttpServletRequest request, HttpServletResponse response){

        Users _user = new Users();
        _user.setUserCode(request.getParameter("userCode"));
        _user.setUserName(request.getParameter("userName"));
        _user.setUserPassword(request.getParameter("userPassword"));
        _user.setGender(request.getParameter("gender"));
        _user.setBirthday(Date.valueOf(request.getParameter("birthday")));
        _user.setPhone(request.getParameter("phone"));
        _user.setAddress(request.getParameter("address"));
        _user.setUserRole(request.getParameter("userRole"));
        Users user = (Users) (request.getSession().getAttribute(Constant.userSession));
        _user.setCreatedBy(Integer.parseInt(user.getUserCode()));
        _user.setCreationDate(new Date(System.currentTimeMillis()));

        boolean flag =  false;

        UserServiceImpl userService = new UserServiceImpl();
        flag = userService.addUser(_user);

        if(flag){
            try {
                response.sendRedirect(request.getContextPath() + "/static/jsp/user.do?method=query");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                response.sendRedirect(request.getContextPath() + "/static/jsp/adduser.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Check whether user has exists in the system or not
    public void verifyUser(HttpServletRequest request, HttpServletResponse response){

        String userCode = request.getParameter("userCode");
        Map<String, String> map = new HashMap<>();

        if(StringUtils.isNullOrEmpty(userCode)){
            map.put("userCode", "exist");
        } else {

            // Find user based on inputted userCode
            UserServiceImpl userService =  new UserServiceImpl();
            Users user = userService.login(userCode);

            if(user != null){
                map.put("userCode", "exist");
            } else {
                map.put("userCode", "notexist");
            }
        }

        response.setContentType("application/json");
        try {
            PrintWriter writer = response.getWriter();
            writer.write(JSONArray.toJSONString(map));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Delete user
    public void deleteUser(HttpServletRequest request, HttpServletResponse response){
        String userid = request.getParameter("userid");
        int id = 0;

        if(!StringUtils.isNullOrEmpty(userid)){
            id = Integer.parseInt(userid);
        } else {
            id = 0;
        }

        Map<String, String> map = new HashMap<>();
        boolean flag = false;

        if(id == 0){
            map.put("delResult","notexist");
        } else {
            UserServiceImpl userService = new UserServiceImpl();
            flag = userService.deleteUser(id);

            if(flag){
                map.put("delResult","true");
            } else {
                map.put("delResult","false");
            }
        }

        try {
            response.setContentType("application/json");
            PrintWriter writer = response.getWriter();
            writer.write(JSONArray.toJSONString(map));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // Update user
    public void updateUser(HttpServletRequest request, HttpServletResponse response){

        String id = request.getParameter("uid");
        String userCode = request.getParameter("userCode");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String gender = request.getParameter("gender");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String userRole = request.getParameter("userRole");
        int modifyBy = ((Users) request.getSession().getAttribute(Constant.userSession)).getId();
        Date modifyDate = new Date(System.currentTimeMillis());

        UserServiceImpl userService = new UserServiceImpl();

        Users _user = new Users();
        _user.setId(Integer.parseInt(id));
        _user.setUserCode(userCode);
        _user.setUserName(userName);
        _user.setUserPassword(userPassword);
        _user.setGender(gender);
        _user.setBirthday(birthday);
        _user.setPhone(phone);
        _user.setAddress(address);
        _user.setUserRole(userRole);
        _user.setModifyBy(modifyBy);
        _user.setModifyDate(modifyDate);

        boolean flag = userService.updateUser(_user);

        if(flag){
            try {
                response.sendRedirect(request.getContextPath()+"/static/jsp/user.do?method=query");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                request.getRequestDispatcher("usermodify.jsp").forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }

    // View user
    public void viewUser(HttpServletRequest request, HttpServletResponse response){

        String uid = request.getParameter("uid");

        if(!StringUtils.isNullOrEmpty(uid)){

            int id = Integer.parseInt(uid);
            UserServiceImpl userService = new UserServiceImpl();
            Users user = userService.viewUser(id);

            request.setAttribute("user",user);

            try {
                request.getRequestDispatcher("userview.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
