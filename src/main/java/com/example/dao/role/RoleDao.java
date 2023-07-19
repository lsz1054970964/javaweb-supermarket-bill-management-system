package com.example.dao.role;

import com.example.pojo.Roles;

import java.sql.Connection;
import java.util.List;

public interface RoleDao {
    // Get role list
    public List<Roles> getRoleList(Connection connection) throws Exception;
}
