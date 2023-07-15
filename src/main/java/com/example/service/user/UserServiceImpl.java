package com.example.service.user;

import com.example.dao.BaseDao;
import com.example.dao.user.UserDao;
import com.example.dao.user.UserDaoImpl;
import com.example.pojo.Users;
import org.junit.Test;

import java.sql.Connection;


public class UserServiceImpl implements UserService{

    // Import Dao layer
    private UserDao userDao;
    public UserServiceImpl(){
        userDao = new UserDaoImpl();
    }

    @Override
    public Users login(String userCode, String userPassword) {
        Connection connection = null;
        Users user = null;

        try {
            connection = BaseDao.getConnection();
            user = userDao.getLoginUser(connection, userCode);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }

        return user;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        String address = userService.login("test","123").getAddress();
        System.out.println(address);
    }
}
