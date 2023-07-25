package com.example.servlet.provider;

import com.example.pojo.Providers;
import com.example.pojo.Users;
import com.example.service.provider.ProviderServiceImpl;
import com.example.util.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProviderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if(method.equals("query")){
            this.getProviderList(req, resp);
        } else if (method.equals("add")) {
            this.addProvider(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void getProviderList(HttpServletRequest req, HttpServletResponse resp){

        String queryProCode = req.getParameter("queryProCode");
        String queryProName = req.getParameter("queryProName");

        List<Providers> providerList = new ArrayList<>();
        ProviderServiceImpl providerService = new ProviderServiceImpl();
        providerList = providerService.getProviderList(queryProCode, queryProName);

        req.setAttribute("providerList", providerList);
        try {
            req.getRequestDispatcher("providerlist.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addProvider(HttpServletRequest req, HttpServletResponse resp){

        String proCode = req.getParameter("proCode");
        String proName = req.getParameter("proName");
        String proContact = req.getParameter("proContact");
        String proPhone = req.getParameter("proPhone");
        String proAddress = req.getParameter("proAddress");
        String proFax = req.getParameter("proFax");
        String proDesc = req.getParameter("proDesc");
        int createdBy = ((Users) req.getSession().getAttribute(Constant.userSession)).getId();
        Date creationDate = new Date(System.currentTimeMillis());

        Providers provider = new Providers();
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProAddress(proAddress);
        provider.setProFax(proFax);
        provider.setProDesc(proDesc);
        provider.setCreatedBy(createdBy);
        provider.setCreationDate(creationDate);

        ProviderServiceImpl providerService = new ProviderServiceImpl();
        boolean flag = providerService.addProvider(provider);

        if(flag){
            try {
                resp.sendRedirect(req.getContextPath()+"/static/jsp/providerlist.jsp");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                req.getRequestDispatcher("provideradd.jsp").forward(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    
}
