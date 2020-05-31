package com.metamong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://192.168.99.100:5432/springboot";
        String username = "metamong";
        String password = "pass";

        /**
         * (16:00) 기존 JDBC 문제점
         * resultMap 에 담고.. 타입 변환의 과정.
         * Connection 에 생기는 비용 등 여러 문제점이 생긴다.
         */
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connection created: " + connection);
            String sql = "INSERT INTO ACCOUNT VALUES (1, 'test@gmail.com', 'pass', 'metamong', false)";
            try(PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
