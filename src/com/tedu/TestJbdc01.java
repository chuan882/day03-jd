package com.tedu;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//JDBC快速入门程序：查询jt_db.account表中的所有数据
public class TestJbdc01 {
    @Test
    public void testFindAll() throws Exception {
//        1注册数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
//        2获取数据库连接(导入java.sql.Connection;包)
        Connection conn=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jt_db?characterEncoding=utf-8",
                "root","root");
//        3获取传输器(导入java.sql.Statement;)
        Statement stat = conn.createStatement();
//        4执行SQl，返回结果
        String sql="select * from account";
        ResultSet rs=stat.executeQuery(sql);
//        5处理结果（打印到控制台）
        while (rs.next()){
//            获取当前行的id，name，money
            int id=rs.getInt("id");
            String name=rs.getString("name");
            double money=rs.getDouble("money");
            System.out.println(id+","+name+","+money);
        }
//        6释放资源---越晚获取的越先关闭
        rs.close();
        stat.close();
        conn.close();


//        System.out.println(conn);
    }

}
