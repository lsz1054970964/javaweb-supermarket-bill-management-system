package com.example.dao.user;

import com.example.pojo.Users;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    // Get login user
    public Users getLoginUser(Connection connection, String userCode) throws Exception;

    // Revise password
    public int updatePassword(Connection connection, int id, String password) throws Exception;
}
