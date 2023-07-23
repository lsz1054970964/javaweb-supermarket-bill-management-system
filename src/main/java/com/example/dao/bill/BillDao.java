package com.example.dao.bill;

import com.example.pojo.Bills;

import java.sql.Connection;
import java.util.List;

public interface BillDao {
    // Get bill list
    public List<Bills> getBillList(Connection connection, String productName, int providerId, int isPayment) throws Exception;
}
