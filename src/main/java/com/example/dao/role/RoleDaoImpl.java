package com.example.dao.role;

import com.example.dao.BaseDao;
import com.example.pojo.Roles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao{
    public List<Roles> getRoleList(Connection connection) throws Exception {

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Object[] params = {};
        List<Roles> rolesList = new ArrayList<Roles>();

        if(connection != null){

            String sql = "select * from `smbms_role`";
            rs = BaseDao.execute(connection, preparedStatement, sql, params,rs);

            while(rs.next()){

                Roles role = new Roles();
                role.setId(rs.getInt("id"));
                role.setRoleCode(rs.getString("roleCode"));
                role.setRoleName(rs.getString("roleName"));

                rolesList.add(role);
            }
            BaseDao.close(null, preparedStatement, rs);
        }

        return rolesList;
    }
}
