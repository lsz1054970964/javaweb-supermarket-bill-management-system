package com.example.service.bill;

import com.example.pojo.Bills;

import java.util.List;

public interface BillService {

    // Get bill list
    public List<Bills> getBillList(String productName, int providerId, int isPayment);

    // Add bill
    public boolean addBill(Bills bill);

    // Get bill by id
    public Bills getBill(int id);

    // Delete bill by id
    public boolean deleteBill(int id);

}
