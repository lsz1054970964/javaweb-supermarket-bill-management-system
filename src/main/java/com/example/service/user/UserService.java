package com.example.service.user;

import com.example.pojo.Roles;
import com.example.pojo.Users;

import java.util.List;

public interface UserService {
    // Users login
    public Users login(String userCode, String userPassword);

    // Revise password based on user id
    public boolean updatePassword(int id, String password);

    // Get user count
    public int getUserCount(String userName, int userRole);

    // Get user list
    public List<Users> getUserList(String userName, int userRole, int currentPageNo, int pageSize);

    // Add user
    public boolean addUser(Users user);

    // Check whether user exists or not
    public Users login(String userCode);

    // Delete user
    public boolean deleteUser(int id);
}
