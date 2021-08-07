package com.t2012e.entity;

import com.t2012e.util.DateTimeUtil;

import java.util.Calendar;
import java.util.Date;

public class Employee {
    private String name;
    private String address;
    private String email;
    private String account;
    private String password;
    private Date createAt;
    private Date updateAt;
    private int status;

    public Employee() {
    }

    public Employee(String name, String address, String email, String account, String password, String strCreateAt, String strUpdateAt, int status) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.createAt = DateTimeUtil.parseDateFromString(strCreateAt);
        this.updateAt = DateTimeUtil.parseDateFromString(strUpdateAt);
        this.status = status;
    }

    public Employee(String name, String address, String email, String account, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.createAt = Calendar.getInstance().getTime();
        this.updateAt = Calendar.getInstance().getTime();
        this.status = 1;
    }

    public Employee(String name, String address, String email, String account, String password, Date createAt, Date updateAt, int status) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.account = account;
        this.password = password;
        this.createAt = Calendar.getInstance().getTime();
        this.updateAt = Calendar.getInstance().getTime();
        this.status = status;
    }


    @Override
    public String toString() {
        return String.format("%5s%10s%5s | %5s%10s%5s | %5s%10s%5s | %5s%10s%5s | %5s%10s%5s | %5s%10s%5s | %5s%10s%5s\n",
                "", this.name, "",
                "", this.address, "",
                "", this.account, "",
                "", this.getCreatedAtString(), "",
                "", this.getUpdateAtString(), "",
                "", this.email, "",
                "", this.getStatusName(), ""
        );
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCreatedAtString() {
        return DateTimeUtil.formatDateToString(this.createAt);
    }

    public String getUpdateAtString() {
        return DateTimeUtil.formatDateToString(this.updateAt);
    }

    private String getStatusName() {
        return this.status == 1 ? "Active": "Deactivate";
    }
}
