package com.example.dao.provider;

import com.example.dao.BaseDao;
import com.example.pojo.Providers;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProviderDaoImpl implements ProviderDao{

    @Override
    public List<Providers> getProviderList(Connection connection, String proCode, String proName) throws Exception {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Providers> providerList = new ArrayList<>();

        if(connection != null){
            StringBuffer sql = new StringBuffer("select * from `smbms_provider` where 1=1");
            ArrayList<Object> params = new ArrayList<>();

            if(!StringUtils.isNullOrEmpty(proCode)){
                sql.append(" and proCode like ?");
                params.add("%"+proCode+"%");
            }

            if(!StringUtils.isNullOrEmpty(proName)){
                sql.append(" and proName like ?");
                params.add("%"+proName+"%");
            }

            resultSet = BaseDao.execute(connection, preparedStatement, sql.toString(), params.toArray(), resultSet);

            while(resultSet.next()){
                Providers provider = new Providers();
                provider.setId(resultSet.getInt("id"));
                provider.setProCode(resultSet.getString("proCode"));
                provider.setProName(resultSet.getString("proName"));
                provider.setProDesc(resultSet.getString("proDesc"));
                provider.setProContact(resultSet.getString("proContact"));
                provider.setProPhone(resultSet.getString("proPhone"));
                provider.setProAddress(resultSet.getString("proAddress"));
                provider.setProFax(resultSet.getString("proFax"));
                provider.setCreationDate(resultSet.getDate("creationDate"));

                providerList.add(provider);
            }
        }

        BaseDao.close(null, preparedStatement, resultSet);

        return providerList;
    }

    @Override
    public int addProvider(Connection connection, Providers provider) throws Exception {

        PreparedStatement preparedStatement = null;
        int execute = 0;

        if(connection != null){

            String sql = "insert into `smbms_provider` (proCode, proName, proContact, proPhone, proAddress," +
                    "proFax, createdBy, creationDate, proDesc) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            Object[] params = {provider.getProCode(), provider.getProName(), provider.getProContact(),
            provider.getProPhone(), provider.getProAddress(), provider.getProFax(), provider.getCreatedBy(),
            provider.getCreationDate(), provider.getProDesc()};

            execute = BaseDao.execute(connection, preparedStatement, sql, params);
        }

        BaseDao.close(null, preparedStatement, null);

        return execute;
    }

    @Override
    public Providers getProvider(Connection connection, int id) throws Exception {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Providers provider = null;

        if(connection != null){

            String sql = "select * from `smbms_provider` where id = ?";
            Object[] params = {id};

            resultSet = BaseDao.execute(connection, preparedStatement, sql, params, resultSet);
            if(resultSet.next()){
                provider.setProCode(resultSet.getString("proCode"));
                provider.setProName(resultSet.getString("proName"));
                provider.setProContact(resultSet.getString("proContact"));
                provider.setProPhone(resultSet.getString("proPhone"));
                provider.setProFax(resultSet.getString("proFax"));
                provider.setProDesc(resultSet.getString("proDesc"));
            }
        }

        BaseDao.close(null, preparedStatement, resultSet);

        return provider;
    }

    @Override
    public int updateProvider(Connection connection, Providers provider) throws Exception {

        PreparedStatement preparedStatement = null;
        int execute = 0;

        if(connection != null){

            String sql = "update `smbms_provider` set proCode = ?, proName = ?, proContact = ?, " +
                    "proPhone = ?, proAddress = ?, proFax = ?, proDesc = ?, modifyBy = ?, " +
                    "modifyDate = ? where id = ?";
            Object[] params = {provider.getProCode(), provider.getProName(), provider.getProContact(),
            provider.getProPhone(), provider.getProAddress(), provider.getProFax(), provider.getProDesc(),
            provider.getModifyBy(), provider.getModifyDate(), provider.getId()};

            execute = BaseDao.execute(connection, preparedStatement, sql, params);

        }

        BaseDao.close(null, preparedStatement, null);

        return execute;
    }
}
