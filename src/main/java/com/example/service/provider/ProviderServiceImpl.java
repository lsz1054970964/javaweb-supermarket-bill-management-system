package com.example.service.provider;

import com.example.dao.BaseDao;
import com.example.dao.provider.ProviderDao;
import com.example.dao.provider.ProviderDaoImpl;
import com.example.pojo.Providers;

import java.sql.Connection;
import java.sql.SQLException;
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

    @Override
    public boolean addProvider(Providers provider) {

        Connection connection = null;
        boolean flag = false;

        try {

            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            int execute = providerDao.addProvider(connection, provider);
            connection.commit();

            if(execute > 0){
                flag = true;
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }

        return flag;
    }

    @Override
    public Providers getProvider(int id) {

        Connection connection = null;
        Providers provider = null;

        try {
            connection = BaseDao.getConnection();
            provider = providerDao.getProvider(connection, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }

        return provider;
    }
}
