package com.zhzye.jdbc;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class StudentDao {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection conn;
    private Statement statement;

    private Connection getDbConnection() {
        if (conn == null) {
            try {
                Class.forName(JDBC_DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                statement = conn.createStatement();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    private ResultSet query(String sql) {
        getDbConnection();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConn() {
        try {
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getStudentCount() {
        Integer ret = 0;
        ResultSet resultSet = query("select count(0) as cnt from students");
        try {
            while (resultSet.next()) {
                ret = resultSet.getInt("cnt");
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConn();
        return ret;
    }
}
