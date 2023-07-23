package com.example.service.provider;

import com.example.dao.BaseDao;
import com.example.dao.provider.ProviderDao;
import com.example.dao.provider.ProviderDaoImpl;
import com.example.pojo.Providers;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProviderServiceImpl implements ProviderService{
    private ProviderDao providerDao;

    public ProviderServiceImpl(){providerDao = new ProviderDaoImpl();}

    @Override
    public List<Providers> getProviderList(String proCode, String proName) {

        Connection connection = null;
        List<Providers> providerList = new ArrayList<>();

        try {
            connection = BaseDao.getConnection();
            providerList = providerDao.getProviderList(connection, proCode, proName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }

        return providerList;
    }
}
