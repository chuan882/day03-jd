package com.c3p0;

import com.jdbcutil.JdbcUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestC3P0 {
//    测试c3p0连接池的使用，往user表中插入一条用户信息
    @Test
    public void testInsert(){
        Connection conn=null;
        PreparedStatement ps=null;
//        创建一个连接池（存放连接的容器）对象
        ComboPooledDataSource pool=new ComboPooledDataSource();
        try {
//            conn = JdbcUtil.getConn();//创建连接对象--造船
//            设置连接 数据库的基本信息
            conn=pool.getConnection();
            String sql="insert into user value(null,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"李逵110");
            ps.setString(2,"123456");
            int rows = ps.executeUpdate();
            System.out.println("影响行数"+rows);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,ps,null);
        }
    }
}
