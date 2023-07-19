package com.example.service.role;

import com.example.dao.BaseDao;
import com.example.dao.role.RoleDao;
import com.example.dao.role.RoleDaoImpl;
import com.example.pojo.Roles;
import com.example.pojo.Users;
import com.example.service.user.UserServiceImpl;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;

    public RoleServiceImpl() {
        roleDao = new RoleDaoImpl();
    }

    public List<Roles> getRoleList() {

        Connection connection = null;
        List<Roles> rolesList = new ArrayList<Roles>();

        try {
            connection = BaseDao.getConnection();
            rolesList = roleDao.getRoleList(connection);

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }
        return rolesList;
    }

    @Test
    public void test(){
        RoleService roleService = new RoleServiceImpl();
        List<Roles> rolesList = roleService.getRoleList();
        for (int i = 0; i < rolesList.size(); i++) {
            System.out.println(rolesList.get(i));
        }

    }
}
