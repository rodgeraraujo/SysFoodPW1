package com.ifpb.pw1.sysfood.dao.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {
    public static Connection getConnection(String url, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
