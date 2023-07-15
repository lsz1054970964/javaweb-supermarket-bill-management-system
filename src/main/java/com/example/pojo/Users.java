package com.example.pojo;

import java.sql.Date;

public class Users {
    private int id;
    private String userCode;
    private String userName;
    private String userPassword;
    private String gender;
    private Date birthday;
    private String phone;
    private String address;
    private String userRole;
    private int createdBy;
    private Date creationDate;
    private int modifyBy;
    private Date modifyDate;

    private String userRoleName;

    public Users() {}

    public Users (int id, String userCode, String userName, String userPassword, String gender,
                  Date birthday, String phone,String address, String userRole, int createdBy,
                  Date creationDate, int modifyBy, Date modifyDate, String userRoleName) {
        this.id = id;
        this.userCode = userCode;
        this.userName = userName;
        this.userPassword = userPassword;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.userRole = userRole;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.userRoleName = userRoleName
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
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

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", userRole='" + userRole + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate='" + creationDate + '\'' +
                ", modifyBy=" + modifyBy +
                ", modifyDate='" + modifyDate + '\'' +
                '}';
    }
}
