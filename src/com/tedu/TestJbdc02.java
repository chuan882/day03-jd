package com.tedu;

import org.junit.Test;

import java.sql.*;

//JDBC快速入门程序：查询jt_db.account表中的所有数据
public class TestJbdc02 {
//    声明conn,stat,rs
Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;


    @Test
    public void testFindAll(){
        try {
        //        1注册数据库驱动---为了MySQL驱动类添加到jdbc程序中
            Class.forName("com.mysql.cj.jdbc.Driver");
//        2获取数据库连接(导入java.sql.Connection;包)--
        conn=DriverManager.getConnection(
//                getConnection相当于建立通道
                "jdbc:mysql:///jt_db?characterEncoding=utf-8",
//                   /协议名（固定）/  localhost和3306端口可以去掉“/”不可以去掉/  只有端口是3306和localhost可以去掉
//                   jt_db?characterEncoding参数写错就不生效了，但不会报错
                "root","root");
//        3获取传输器(导入java.sql.Statement;)
         stat = conn.createStatement();
//        4执行SQl，返回结果
        String sql="select * from account";
         rs=stat.executeQuery(sql);//executeQuery查询  executeUpdate()修改
//        5处理结果（打印到控制台）
        while (rs.next()){
//            获取当前行的id，name，money
            int id=rs.getInt("id");
            String name=rs.getString("name");
            double money=rs.getDouble("money");
            System.out.println(id+","+name+","+money);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
//        6释放资源---越晚获取的越先关闭
         if (rs!=null) {
             try {
                 rs.close();
             } catch (SQLException e) {
                 e.printStackTrace();
             } finally {
//                 //                将rs置为null，结果集对象就会变成一个游离对象，时间一长，也会被回收
                 rs=null;
             }
         }if (stat!=null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
//                 //                将rs置为null，结果集对象就会变成一个游离对象，时间一长，也会被回收
                    stat=null;
                }
            }if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
//                 //                将rs置为null，结果集对象就会变成一个游离对象，时间一长，也会被回收
                    conn=null;
                }
            }
        }


//        System.out.println(conn);
    }

}
