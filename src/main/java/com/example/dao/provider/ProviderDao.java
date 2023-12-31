package com.example.dao.provider;

import com.example.pojo.Providers;

import java.sql.Connection;
import java.util.List;

public interface ProviderDao {

    // Get provider list
    public List<Providers> getProviderList(Connection connection, String proCode, String proName) throws Exception;

    // Add provider
    public int addProvider(Connection connection, Providers provider) throws Exception;

    // Get provider by id
    public Providers getProvider(Connection connection, int id) throws Exception;

    // Update provider by id
    public int updateProvider(Connection connection, Providers provider) throws Exception;

    // Delete provider by id
    public int deleteProvider(Connection connection, int id) throws Exception;

}
