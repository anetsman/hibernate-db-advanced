package com.hb.onetoone.unidirectional;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args) {

        String driverName = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driverName).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String jdbcURL = "jdbc:mysql://localhost/hb-01-one-to-one-unidirectional?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcURL);

            Connection connection = DriverManager.getConnection(jdbcURL, user, password);

            System.out.println("Connection successful!!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
