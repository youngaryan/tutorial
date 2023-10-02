package com.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/ss_l2_e1";
        String username = "root";
        String password = "Aa*123456";
        String query = "insert into authorities values (6, 'hey')";

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);

        Statement st = connection.createStatement();

        int count = st.executeUpdate(query);

        // while (rs.next()) {
        // int id = rs.getInt(1);

        // System.out.println(id);

        // System.out.println(rs.getString(2));

        // }

        st.close();
        connection.close();
    }
}