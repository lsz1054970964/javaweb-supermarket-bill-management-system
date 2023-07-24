package com.example.servlet.bill;

import com.example.pojo.Bills;
import com.example.pojo.Providers;
import com.example.pojo.Users;
import com.example.service.bill.BillServiceImpl;
import com.example.service.provider.ProviderServiceImpl;
import com.example.util.Constant;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class BillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if(method.equals("query")){
            this.getBillList(req, resp);
        } else if (method.equals("add")) {
            this.addBill(req, resp);
        } else if (method.equals("view")){
            this.getBill(req, resp);
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

    public void addBill(HttpServletRequest req, HttpServletResponse resp){

        String billCode = req.getParameter("billCode");
        String productName = req.getParameter("productName");
        String productUnit = req.getParameter("productUnit");
        String productCount = req.getParameter("productCount");
        String totalPrice = req.getParameter("totalPrice");
        String providerId = req.getParameter("providerId");
        String isPayment = req.getParameter("isPayment");

        Bills bill = new Bills();
        bill.setBillCode(billCode);
        bill.setProviderName(productName);
        bill.setProductUnit(productUnit);
        bill.setProductCount(Float.parseFloat(productCount));
        bill.setTotalPrice(Float.parseFloat(totalPrice));
        bill.setProviderId(Integer.parseInt(providerId));
        bill.setIsPayment(Integer.parseInt(isPayment));
        bill.setCreatedBy(((Users) req.getSession().getAttribute(Constant.userSession)).getId());
        bill.setCreationDate(new Date(System.currentTimeMillis()));

        BillServiceImpl billService = new BillServiceImpl();
        boolean flag = billService.addBill(bill);

        if(flag){
            try {
                resp.sendRedirect(req.getContextPath()+"/static/jsp/bill.do?method=query");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                req.getRequestDispatcher("billadd.jsp").forward(req,resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void getBill(HttpServletRequest req, HttpServletResponse resp){
        String billid = req.getParameter("billid");
        Bills bill = new Bills();

        if(!StringUtils.isNullOrEmpty(billid)){
            int id = Integer.parseInt(billid);
            BillServiceImpl billService = new BillServiceImpl();
            bill = billService.getBill(id);
            req.setAttribute("bill",bill);

            try {
                req.getRequestDispatcher("billview.jsp").forward(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
