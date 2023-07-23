package com.example.dao.bill;

import com.example.dao.BaseDao;
import com.example.pojo.Bills;
import com.mysql.cj.util.StringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao{
    @Override
    public List<Bills> getBillList(Connection connection, String productName, int providerId, int isPayment) throws Exception {

        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Bills> billList = new ArrayList<Bills>();

        if(connection != null){
            StringBuffer sql = new StringBuffer("select * from `smbms_bill` b join `smbms_provider` p where b.providerId = p.id");
            ArrayList<Object> params = new ArrayList<>();

            if(!StringUtils.isNullOrEmpty(productName)){
                sql.append(" and productName like ?");
                params.add("%"+productName+"%");
            }

            if(providerId > 0){
                sql.append(" and providerId = ?");
                params.add(providerId);
            }

            if(isPayment > 0){
                sql.append(" and isPayment = ?");
                params.add(isPayment);
            }

            rs = BaseDao.execute(connection, preparedStatement, sql.toString(), params.toArray(), rs);

            while(rs.next()){
                Bills bill = new Bills();
                bill.setId(rs.getInt("id"));
                bill.setBillCode(rs.getString("billCode"));
                bill.setProductName(rs.getString("productName"));
                bill.setProviderName(rs.getString("providerName"));
                bill.setTotalPrice(rs.getFloat("totalPrice"));
                bill.setIsPayment(rs.getInt("isPayment"));
                bill.setCreationDate(rs.getDate("creationDate"));

                billList.add(bill);
            }
        }

        BaseDao.close(null, preparedStatement, rs);

        return billList;
    }
}
