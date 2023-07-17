package com.example.service.user;

import com.example.pojo.Users;

public interface UserService {
    // Users login
    public Users login(String userCode, String userPassword);

    // Revise password based on user id
    public boolean updatePassword(int id, String password);
}
