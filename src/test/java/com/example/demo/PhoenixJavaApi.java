package com.example.demo;

/**
 * Created by hadoopuser on 11/2/19.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PhoenixJavaApi {

    public static void main(String[] args) throws Exception {

        // 加载数据库驱动
        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");

        /*
         * 指定数据库地址,格式为 jdbc:phoenix:Zookeeper 地址
         * 如果 HBase 采用 Standalone 模式或者伪集群模式搭建，则 HBase 默认使用内置的 Zookeeper，默认端口为 2181
         */
        Connection connection = DriverManager.getConnection("jdbc:phoenix:hadoopnode:2181");

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM tbl_order");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println(resultSet.getString("order_code") + " "
                    + resultSet.getInt("user_id"));
        }

        statement.close();
        connection.close();
    }
}