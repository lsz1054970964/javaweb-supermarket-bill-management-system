package com.example.service.bill;

import com.example.dao.BaseDao;
import com.example.dao.bill.BillDao;
import com.example.dao.bill.BillDaoImpl;
import com.example.pojo.Bills;

import java.sql.Connection;
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
}