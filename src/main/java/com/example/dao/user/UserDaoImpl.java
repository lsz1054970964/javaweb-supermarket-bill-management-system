package com.example.dao.user;

import com.example.dao.BaseDao;
import com.example.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    // Get login user
    public Users getLoginUser(Connection connection, String userCode) throws Exception{

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Users user = null;

        if(connection != null){
            String sql = "select * from `smbms_user` where userCode=?";
            Object[] params = {userCode};

            resultSet = BaseDao.execute(connection, preparedStatement, sql, params, resultSet);

            if(resultSet.next()){
                user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserCode(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("userPassword"));
                user.setGender(resultSet.getString("gender"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setUserRole(resultSet.getString("userRole"));
                user.setCreatedBy(resultSet.getInt("createdBy"));
                user.setCreationDate(resultSet.getDate("creationDate"));
                user.setModifyBy(resultSet.getInt("modifyBy"));
                user.setModifyDate(resultSet.getDate("modifyDate"));

                BaseDao.close(null, preparedStatement, resultSet);
            }
        }

        return user;
    }

    // Revise password


    @Override
    public int updatePassword(Connection connection, int id, String password) throws Exception {

        PreparedStatement preparedStatement = null;
        int execute = 0;

        if(connection != null){
            String sql="update `smbms_user` set userPassword=? where id=?";
            Object params[] = {password,id};

            execute = BaseDao.execute(connection, preparedStatement, sql, params);

            BaseDao.close(null, preparedStatement,null);
        }



        return execute;
    }
}
