package com.example.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

// Public class to manipulate the database
public class BaseDao {
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    // Run when the class is loading
    static {
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();

        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
    }

    // Connect to the database
    public static Connection getConnection() throws Exception {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }

    // Read
    public static ResultSet execute(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params, ResultSet resultSet) throws Exception {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            // setObject starts from 1 but Object[] starts from 0
            preparedStatement.setObject(i+1, params);
        }

        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    // Create, Update and Delete
    public static int execute(Connection connection, PreparedStatement preparedStatement, String sql, Object[] params) throws Exception {
        preparedStatement = connection.prepareStatement(sql);

        for (int i = 0; i < params.length; i++) {
            // setObject starts from 1 but Object[] starts from 0
            preparedStatement.setObject(i+1, params);
        }

        int n = preparedStatement.executeUpdate();

        return n;
    }

    public static boolean close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        boolean flag = true;

        if(resultSet != null){
            try {
                resultSet.close();
                resultSet = null;
            } catch (SQLException e) {
                flag = false;
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
                preparedStatement = null;
            } catch (SQLException e) {
                flag = false;
            }
        }
        if(connection != null){
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                flag = false;
            }
        }

        return  flag;
    }
}

