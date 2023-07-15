package com.example.service.user;

import com.example.pojo.Users;

public interface UserService {
    public Users login(String userCode, String userPassword);
}
