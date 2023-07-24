package com.example.service.bill;

import com.example.dao.BaseDao;
import com.example.dao.bill.BillDao;
import com.example.dao.bill.BillDaoImpl;
import com.example.pojo.Bills;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillServiceImpl implements BillService{
    private BillDao billDao;

    public BillServiceImpl() {billDao = new BillDaoImpl();}

    @Override
    public List<Bills> getBillList(String productName, int providerId, int isPayment) {

        Connection connection = null;
        List<Bills> billList = new ArrayList<Bills>();

        try {
            connection = BaseDao.getConnection();
            billList = billDao.getBillList(connection, productName, providerId, isPayment);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }

        return billList;
    }

    @Override
    public boolean addBill(Bills bill) {

        boolean flag = false;
        Connection connection = null;
        int execute = 0;

        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            execute = billDao.addBill(connection, bill);
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
    public Bills getBill(int id) {

        Connection connection = null;
        Bills bill = new Bills();

        try {
            connection = BaseDao.getConnection();
            bill = billDao.getBill(connection, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            BaseDao.close(connection, null, null);
        }

        return bill;
    }

    @Override
    public boolean deleteBill(int id) {

        Connection connection = null;
        boolean flag = false;
        int execute = 0;

        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            execute = billDao.deleteBill(connection, id);
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
    public boolean modifyBill(Bills bill) {

        Connection connection = null;
        boolean flag = false;
        int execute = 0;

        try {
            connection = BaseDao.getConnection();
            connection.setAutoCommit(false);
            execute = billDao.updateBill(connection, bill);
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
}
