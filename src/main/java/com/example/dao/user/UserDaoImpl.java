package com.example.dao.user;

import com.example.dao.BaseDao;
import com.example.pojo.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    public Users getLoginUser(Connection connection, String userCode){

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Users user = null;

        if(connection != null){
            String sql = "select * from `smbms_user` where userCode=?";
            Object[] params = {userCode};

            try {
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
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        return user;
    }
}
