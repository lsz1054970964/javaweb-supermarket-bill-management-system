package com.example.dao.bill;

import com.example.pojo.Bills;

import java.sql.Connection;
import java.util.List;

public interface BillDao {
    // Get bill list
    public List<Bills> getBillList(Connection connection, String productName, int providerId, int isPayment) throws Exception;

    // Add bill
    public int addBill(Connection connection, Bills bill) throws Exception;

    // Get bill by id
    public Bills getBill(Connection connection, int id) throws Exception;

    // Delete bill by id
    public int deleteBill(Connection connection, int id) throws Exception;

    // Update bill by id
    public int updateBill(Connection connection, Bills bill) throws Exception;

    // Count bill by provider id
    public int countBill(Connection connection, int id) throws Exception;
}
