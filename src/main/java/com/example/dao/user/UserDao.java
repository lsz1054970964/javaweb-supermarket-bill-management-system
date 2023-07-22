package com.example.dao.user;

import com.example.pojo.Roles;
import com.example.pojo.Users;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    // Get login user
    public Users getLoginUser(Connection connection, String userCode) throws Exception;

    // Revise password
    public int updatePassword(Connection connection, int id, String password) throws Exception;

    // Get user count
    public int getUserCount(Connection connection, String userName, int userRole) throws Exception;

    // Get user list
    public List<Users> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;

    // Add user
    public int addUser(Connection connection, Users user) throws Exception;

    // Delete user
    public int deleteUser(Connection connection, int id) throws Exception;

    // Update user
    public  int updateUser(Connection connection, Users user) throws Exception;

    // View user
    public Users viewUser(Connection connection, int id) throws  Exception;
}
