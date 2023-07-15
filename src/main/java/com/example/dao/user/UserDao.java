package com.example.dao.user;

import com.example.pojo.Users;

import java.sql.Connection;

public interface UserDao {
    public Users getLoginUser(Connection connection, String userCode);
}
