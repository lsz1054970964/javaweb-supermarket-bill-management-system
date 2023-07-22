package com.example.dao.user;

import com.example.dao.BaseDao;
import com.example.pojo.Roles;
import com.example.pojo.Users;
import com.mysql.cj.util.StringUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public int getUserCount(Connection connection, String userName, int userRole) throws Exception {

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int cnt = 0;

        if(connection != null){

            StringBuffer sql = new StringBuffer();
            sql.append("select count(1) as count from `smbms_user` u join `smbms_role` r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<Object>();

            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }

            if(userRole > 0){
                sql.append(" and r.id = ?");
                list.add(userRole);
            }

            Object[] params = list.toArray();

            rs = BaseDao.execute(connection, preparedStatement, sql.toString(), params ,rs);

            if(rs.next()){
                cnt = rs.getInt("count");
            }

            BaseDao.close(null, preparedStatement, rs);
        }

        return cnt;
    }

    @Override
    public List<Users> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Users> usersList = new ArrayList<Users>();

        if(connection != null){
            StringBuffer sql = new StringBuffer();
            sql.append("select * from `smbms_user` u join `smbms_role` r where u.userRole = r.id");
            ArrayList<Object> list = new ArrayList<Object>();

            if(!StringUtils.isNullOrEmpty(userName)){
                sql.append(" and u.userName like ?");
                list.add("%"+userName+"%");
            }

            if(userRole > 0){
                sql.append(" and r.id = ?");
                list.add(userRole);
            }

            int startIndex = (currentPageNo - 1) * pageSize;
            sql.append(" limit ?, ?");
            list.add(startIndex);
            list.add(pageSize);

            Object[] params = list.toArray();

            rs = BaseDao.execute(connection, preparedStatement, sql.toString(),params, rs);

            while(rs.next()){
                Users user = new Users();
                user.setId(rs.getInt("id"));
                user.setUserCode(rs.getString("userCode"));
                user.setUserCode(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setGender(rs.getString("gender"));
                user.setBirthday(rs.getDate("birthday"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                //user.setUserRole(rs.getString("userRole"));
                user.setUserRole(rs.getString("roleName"));

                usersList.add(user);
            }

            BaseDao.close(null, preparedStatement, rs);
        }

        return usersList;
    }

    @Override
    public int addUser(Connection connection, Users user) throws Exception {

        PreparedStatement preparedStatement = null;
        int execute = 0;

        if(connection != null){
            String sql = "insert into `smbms_user` (userCode, userName, userPassword, gender, birthday, " +
                    "phone, address, userRole, createdBy, creationDate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] params = {user.getUserCode(), user.getUserName(), user.getUserPassword(), user.getGender()
                    , user.getBirthday(), user.getPhone(), user.getAddress(), user.getCreatedBy()
                    , user.getCreationDate()};

            execute = BaseDao.execute(connection, preparedStatement, sql, params);
        }
        BaseDao.close(null, preparedStatement, null);
        return execute;
    }

    @Override
    public int deleteUser(Connection connection, int id) throws Exception {

        PreparedStatement preparedStatement = null;
        int execute = 0;

        if(connection != null){
            String sql = "delete from `smbms_user` where userCode = ?";
            Object[] params = {id};

            execute = BaseDao.execute(connection, preparedStatement, sql, params);
        }

        BaseDao.close(null, preparedStatement, null);

        return execute;
    }

}
