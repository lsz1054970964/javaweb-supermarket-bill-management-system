package com.example.servlet.bill;

import com.example.pojo.Bills;
import com.example.pojo.Providers;
import com.example.service.bill.BillServiceImpl;
import com.example.service.provider.ProviderServiceImpl;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class BillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if(method.equals("query")){
            this.getBillList(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void getBillList(HttpServletRequest req, HttpServletResponse resp){

        String productName = req.getParameter("queryProductName");

        int providerId = 0;
        if(!StringUtils.isNullOrEmpty(req.getParameter("queryProviderId"))){
            providerId = Integer.parseInt(req.getParameter("queryProviderId"));
        }

        int isPayment = 0;
        if(!StringUtils.isNullOrEmpty(req.getParameter("queryIsPayment"))){
            isPayment = Integer.parseInt(req.getParameter("queryIsPayment"));
        }

        BillServiceImpl billService = new BillServiceImpl();
        List<Bills> billList = billService.getBillList(productName, providerId, isPayment);

        req.setAttribute("billList", billList);

        ProviderServiceImpl providerService = new ProviderServiceImpl();
        List<Providers> providerList =  providerService.getProviderList(null, null);
        req.setAttribute("providerList", providerList);

        try {
            req.getRequestDispatcher("billlist.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
