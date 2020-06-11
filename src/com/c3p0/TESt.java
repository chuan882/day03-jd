package com.c3p0;

import com.jdbcutil.JdbcUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TESt {

     @Test

    public void tesr(){
        Connection conn=null;
        PreparedStatement ps=null;
            ComboPooledDataSource pool=new ComboPooledDataSource();
        try {
            conn=pool.getConnection();
            String sql="update user set password=? where username=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,"123456");
            ps.setString(2,"张飞");
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtil.close(conn,ps,null);
        }
    }
}

