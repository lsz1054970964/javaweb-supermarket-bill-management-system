package com.example.pojo;

import java.sql.Date;

public class Bills {
    private int id;
    private String billCode;
    private String productName;
    private String productDesc;
    private String productUnit;
    private float productCount;
    private float totalPrice;
    private int isPayment;
    private int createdBy;
    private Date creationDate;
    private int modifyBy;
    private Date modifyDate;
    private int providerId;

    private String providerName;

    public Bills() {

    }

    public Bills (int id, String billCode, String productName, String productDesc, String productUnit,
                 float productCount, float totalPrice, int isPayment, int createdBy, Date creationDate,
                 int modifyBy, Date modifyDate, int providerId, String providerName) {
        this.id = id;
        this.billCode = billCode;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productUnit = productUnit;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.isPayment = isPayment;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.providerId = providerId;
        this.providerName = providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductCount(float productCount) {
        this.productCount = productCount;
    }

    public float getProductCount() {
        return productCount;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
    }

    public int getIsPayment() {
        return isPayment;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setModifyBy(int modifyBy) {
        this.modifyBy = modifyBy;
    }

    public int getModifyBy() {
        return modifyBy;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getProviderId() {
        return providerId;
    }

    @Override
    public String toString() {
        return "Bills{" +
                "id=" + id +
                ", billCode='" + billCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", productCount=" + productCount +
                ", totalPrice=" + totalPrice +
                ", isPayment=" + isPayment +
                ", createdBy=" + createdBy +
                ", creationDate='" + creationDate + '\'' +
                ", modifyBy=" + modifyBy +
                ", modifyDate='" + modifyDate + '\'' +
                ", providerId=" + providerId +
                '}';
    }
}

