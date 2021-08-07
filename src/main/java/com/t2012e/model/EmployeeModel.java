package com.t2012e.model;

import com.t2012e.entity.Employee;
import com.t2012e.util.ConnectionHelper;
import com.t2012e.util.DateTimeUtil;

import java.sql.*;
import java.util.Date;

public class EmployeeModel {
    /**
     * Phương thức "register" Cho phép đăng ký tài
     * khoản, trả về true nếu tạo tài khoản thành công, false và in ra
     * thông tin lỗi nếu không thể tạo tài khoản.
     * created by Kiennx
     * created at 07/8/2021
     * @param emp
     * @return
     */
    public boolean register(Employee emp){
        try {
            //Login và kết nối -> đối tượng của connection.
            Connection cnn = ConnectionHelper.getConnection();
            if(cnn == null){
                throw new SQLException("Can't open connection");
            }
            PreparedStatement prepareStatement = cnn.prepareStatement("insert into employees (name, address, email, account, password, createAt, updateAt, status) values (?, ?, ?, ?, ?, ?, ?, ?)");
            prepareStatement.setString(1, emp.getName());
            prepareStatement.setString(2, emp.getAddress());
            prepareStatement.setString(3, emp.getEmail());
            prepareStatement.setString(4, emp.getAccount());
            prepareStatement.setString(5, emp.getPassword());
            prepareStatement.setString(6, emp.getCreatedAtString());
            prepareStatement.setString(7, emp.getUpdateAtString());
            prepareStatement.setInt(8, emp.getStatus());
            prepareStatement.execute();
            return true;
        } catch (SQLException sqlException) {
            System.out.println("fails!");
        }
        return false;
    }

    /**
     * Phương thức "checkExistAccount"
     * Nhận tham số đầu vào là tài khoản của nhân viên, hàm này kiểm tra sự tồn tại của
     * tài khoản trong database, trả về true nếu có tài khoản, false nếu
     * không tồn tại.
     * created by Kiennx
     * created at 07/8/2021
     */
    public boolean checkExistAccount(String account){
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                throw new SQLException("Can't open connection");
            }
            PreparedStatement preparedStatement = cnn.prepareStatement("select  * from employees where account = ?");
            preparedStatement.setString(1,account);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String acc = rs.getString("account");
                if (acc == account) {
                    break;
                }
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    /**
     * Phương thức "login" cho phép
     * nhân viên đăng nhập vào hệ thống, nếu thông tin account và
     * password là đúng thì trả về thông tin nhân viên, nếu sai trả về null.
     * created by Kiennx
     * created at 07/8/2021
     */
    public Employee login(String account, String password){
        Employee employee = null;
        try {
            Connection cnn = ConnectionHelper.getConnection();
            if (cnn == null) {
                throw new SQLException("Can't open connection");
            }
            PreparedStatement preparedStatement = cnn.prepareStatement("select * from employees where account = ? and password = ?");
            preparedStatement.setString(1, account);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                account = rs.getString("account");
                password = rs.getString("password");
                Date createAt = DateTimeUtil.parseDateFromString(rs.getString("createAt"));
                Date updateAt = DateTimeUtil.parseDateFromString(rs.getString("updateAt"));
                int status = rs.getInt("status");
                employee = new Employee(name, address, email, account, password, createAt, updateAt, status);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }

}

