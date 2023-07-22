package com.example.service.user;

import com.example.dao.BaseDao;
import com.example.dao.user.UserDao;
import com.example.dao.user.UserDaoImpl;
import com.example.pojo.Users;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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

    @Override
    public boolean updatePassword(int id, String password) {
        Connection connection = null;
        boolean flag = false;

        try {
            connection = BaseDao.getConnection();
            if(userDao.updatePassword(connection, id, password)>0){
                flag = true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }
        return flag;
    }

    @Override
    public int getUserCount(String userName, int userRole) {
        Connection connection = null;
        int cnt = 0;

        try {
            connection = BaseDao.getConnection();
            cnt = userDao.getUserCount(connection, userName, userRole);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }

        return cnt;
    }

    @Override
    public List<Users> getUserList(String userName, int userRole, int currentPageNo, int pageSize) {
        Connection connection = null;
        List<Users> usersList = new ArrayList<Users>();

        try {
            connection = BaseDao.getConnection();
            usersList = userDao.getUserList(connection, userName, userRole, currentPageNo, pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }

        return usersList;
    }

    @Override
    public boolean addUser(Users user) {

        boolean flag = false;
        Connection connection = null;
        int execute = 0;

        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            execute = userDao.addUser(connection, user);
            connection.commit();
            if( execute > 0){
                flag = true;
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            BaseDao.close(connection, null, null);
        }

        return flag;
    }

    @Override
    public Users login(String userCode) {
        Connection connection = null;
        Users user =  null;

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

    @Override
    public boolean deleteUser(int id) {

        boolean flag = false;
        Connection connection = null;
        int execute = 0;

        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            execute = userDao.deleteUser(connection, id);
            connection.commit();

            if (execute > 0){
                flag = true;
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            BaseDao.close(connection, null,null);
        }

        return flag;
    }

    @Override
    public boolean updateUser(Users user) {

        boolean flag = false;
        Connection connection = null;
        int execute = 0;

        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            execute = userDao.updateUser(connection, user);
            connection.commit();

            if(execute > 0) {
                flag = true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }

        return flag;
    }

    @Test
    public void test(){
        UserServiceImpl userService = new UserServiceImpl();
        List<Users> usersList  = userService.getUserList(null,0, 1,5);
        for (int i = 0; i < usersList.size(); i++) {
            System.out.println(usersList.get(i));
        }

    }
}
