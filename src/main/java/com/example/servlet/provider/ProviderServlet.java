package com.example.servlet.provider;

import com.alibaba.fastjson2.JSONArray;
import com.example.pojo.Providers;
import com.example.pojo.Users;
import com.example.service.provider.ProviderServiceImpl;
import com.example.util.Constant;
import com.mysql.cj.util.StringUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProviderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");

        if(method.equals("query")){
            this.getProviderList(req, resp);
        } else if (method.equals("add")) {
            this.addProvider(req, resp);
        } else if (method.equals("view")){
            this.getProvider(req, resp, "providerview.jsp");
        } else if (method.equals("modifysave")) {
            this.updateProvider(req, resp);
        } else if (method.equals("modify")) {
            this.getProvider(req, resp, "providermodify.jsp");
        } else if (method.equals("delprovider")) {
            this.deleteProvider(req, resp);
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

    public void getProvider(HttpServletRequest req, HttpServletResponse resp, String url){

        String proid = req.getParameter("proid");
        if(!StringUtils.isNullOrEmpty(proid)){

            int id = Integer.parseInt(proid);
            ProviderServiceImpl providerService = new ProviderServiceImpl();
            Providers provider = new Providers();
            provider = providerService.getProvider(id);

            req.setAttribute("provider", provider);

            try {
                req.getRequestDispatcher(url).forward(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void updateProvider(HttpServletRequest req, HttpServletResponse resp){

        String id = req.getParameter("id");
        String proCode = req.getParameter("proCode");
        String proName = req.getParameter("proName");
        String proContact = req.getParameter("proContact");
        String proPhone = req.getParameter("proPhone");
        String proAddress = req.getParameter("proAddress");
        String proFax = req.getParameter("proFax");
        String proDesc = req.getParameter("proDesc");
        int modifyBy = ((Users) req.getSession().getAttribute(Constant.userSession)).getId();
        Date modifyDate = new Date(System.currentTimeMillis());

        Providers provider = null;
        provider.setId(Integer.parseInt(id));
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProAddress(proAddress);
        provider.setProFax(proFax);
        provider.setProDesc(proDesc);
        provider.setModifyBy(modifyBy);
        provider.setModifyDate(modifyDate);

        ProviderServiceImpl providerService = new ProviderServiceImpl();
        boolean flag = providerService.updateProvider(provider);

        if(flag){
            try {
                resp.sendRedirect(req.getContextPath()+"/static/jsp/provider.do?method=query");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                req.getRequestDispatcher("providermodify.jsp").forward(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void deleteProvider(HttpServletRequest req, HttpServletResponse resp){

        String proid = req.getParameter("proid");

        if(!StringUtils.isNullOrEmpty(proid)){

            int id = Integer.parseInt(proid);
            ProviderServiceImpl providerService = new ProviderServiceImpl();
            int flag = providerService.deleteProvider(id);
            Map<String, String> map = new HashMap<>();

            if(flag == 1){
                map.put("delResult", "true");
            } else if(flag == -1){
                map.put("delResult","false");
            } else if (flag == 0) {
                map.put("delResult","notexist");
            } else {
                map.put("delResult","cannot");
            }

            try {
                resp.setContentType("application/json");
                PrintWriter writer = resp.getWriter();
                writer.write(JSONArray.toJSONString(map));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
