package com.zhzye.jdbc;

import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDao {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/school";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection conn;
    private Statement statement;

    public Connection getDbConnection() {
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

    public void dropTables() {
        getDbConnection();
        try {
            statement.execute("drop table users");
            statement.execute("drop table classes");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTables() {
        getDbConnection();
        try {
            statement.execute("create table users(uid bigint(20) not null auto_increment, cid bigint(20) not null, " +
                    "uname varchar(200) not null default '', primary key(uid))");
            statement.execute("create table classes(cid bigint(20) not null auto_increment, " +
                    "cname varchar(200) not null default '', primary key(cid))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveStudentAndClassWithOpenTx() {
        getDbConnection();
        try {
            conn.setAutoCommit(false);
            statement.execute("insert into classes(cname) values('classA')");
            statement.execute("insert into users(uname, cid) values ('userA', 1)");
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }

    public Integer getUsersCount() {
        Integer ret = 0;
        ResultSet resultSet = query("select count(0) as cnt from users");
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
