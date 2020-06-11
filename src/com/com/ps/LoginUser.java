package com.com.ps;

import com.jdbcutil.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//模拟用户登陆案例
public class LoginUser {
    public static void main(String[] args) {
//        提示用户登陆，用户输入用户名并接受用户名
        System.out.println("请登录");
        System.out.println("请输入用户名：");
        String user = new Scanner(System.in).nextLine();
//        提示用户输入密码并接受
        System.out.println("请输入密码：");
        String psw = new Scanner(System.in).nextLine();
//        根据用户名和密码进行登陆
        login(user,psw);
    }
@Test
    private static void login(String user, String psw) {
    Connection conn=null;
    Statement stat=null;
    ResultSet rs=null;
    try {
        conn = JdbcUtil.getConn();
        stat=conn.createStatement();
        String sql="select * from user where username='"+user+"' and password='"+psw+"'";
        rs = stat.executeQuery(sql);
        if(rs.next() ){
            System.out.println("账号密码正确");
        }else{
            System.out.println("登录失败");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        JdbcUtil.close(conn,stat,rs);
    }
}
}
