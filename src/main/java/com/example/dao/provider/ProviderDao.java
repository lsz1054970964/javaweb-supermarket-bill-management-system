package com.example.dao.provider;

import com.example.pojo.Providers;

import java.sql.Connection;
import java.util.List;

public interface ProviderDao {

    // Get provider list
    public List<Providers> getProviderList(Connection connection, String proCode, String proName) throws Exception;
}
