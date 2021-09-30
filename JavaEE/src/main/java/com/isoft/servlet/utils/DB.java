package com.isoft.servlet.utils;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/hr_mg?serverTimezone=Asia/Shanghai&characterEncoding=UTF-8&useUnicode=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static String NAME  = "root";
    private static String PASSWORD = "000541";

    private static Connection connection = null;

    public static Connection getConnection() {
        return connection;
    }


    /*public static void getParam(String filename) {
        File file = new File(filename);
        Properties po = new Properties();

        try {
            FileInputStream fi = new FileInputStream(file);
            po.load(fi);
            DRIVER = po.getProperty("DRIVER");
            URL = po.getProperty("URL");
            NAME = po.getProperty("NAME");
            PASSWORD = po.getProperty("PASSWORD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    private DB() {

    }
    static {
//        getParam("src//com//isoft//utils//mysql.properties");
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
