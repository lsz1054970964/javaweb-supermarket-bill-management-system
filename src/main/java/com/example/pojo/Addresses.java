package com.example.pojo;

import java.sql.Date;

public class Addresses {
    private int id;
    private String contact;
    private String addressDesc;
    private String postCode;
    private String tel;
    private int createdBy;
    private Date creationDate;
    private int modifyBy;
    private Date modifyDate;
    private int userId;

    public Addresses() {

    }

    public Addresses (int id, String contact, String addressDesc, String postCode,
                      String tel, int createdBy, Date creationDate, int modifyBy,
                      Date modifyDate, int userId){
        this.id = id;
        this.contact = contact;
        this.addressDesc = addressDesc;
        this.postCode = postCode;
        this.tel = tel;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc;
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
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

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "id=" + id +
                ", contact='" + contact + '\'' +
                ", addressDesc='" + addressDesc + '\'' +
                ", postCode='" + postCode + '\'' +
                ", tel='" + tel + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate='" + creationDate + '\'' +
                ", modifyBy=" + modifyBy +
                ", modifyDate='" + modifyDate + '\'' +
                ", userId=" + userId +
                '}';
    }
}


