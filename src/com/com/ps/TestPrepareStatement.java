package com.com.ps;

import com.jdbcutil.JdbcUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//练习PrepareStatement对象的使用
public class TestPrepareStatement {
//    1往user表中插入一条用户信息：孙尚香 123456
    @Test
//    public void testInsert(){
//        Connection conn=null;
//        PreparedStatement stat=null;
//        ComboPooledDataSource pool=new ComboPooledDataSource();
//        try {
//            conn = pool.getConnection();
//            String sql= "insert into user value(null,?,?)";
//            stat = conn.prepareStatement(sql);
//            stat.setString(1,"孙尚香");
//            stat.setString(2,"123456");
//            stat.executeUpdate();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            JdbcUtil.close(conn,stat,null);
//        }
//    }
//    2查询user表中的所有信息，并输出到控制台
//    如果sql语句中没有参数（也就是没有？），也就不需要设置参数
    public void testFindAll(){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ComboPooledDataSource pool=new ComboPooledDataSource();
        try {
            conn=pool.getConnection();
            String sql="select * from user";
            ps = conn.prepareStatement(sql);
             rs= ps.executeQuery();
             while(rs.next()) {
                 int id = rs.getInt("id");
                 String username = rs.getString("username");
                 String password = rs.getString("password");
                 System.out.println(id+","+username+","+password);
             }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,ps,rs);
        }
    }

}
