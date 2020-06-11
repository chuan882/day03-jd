package com.tedu;

import com.jdbcutil.JdbcUtil;
import java.sql.Connection;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.Statement;

//完成JDBC的增删改操作
public class TestJdbc03 {
    @Test
    public void testDind(){
        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;
        try {
            conn= JdbcUtil.getConn();
            stat = conn.createStatement();
            String sql="select * from account where name='join'";
            rs = stat.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double money = rs.getDouble("money");
                System.out.println(name+"  "+id+"  "+money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,stat,rs);
        }
    }
}
