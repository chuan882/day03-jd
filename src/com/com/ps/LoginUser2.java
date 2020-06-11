package com.com.ps;

import com.jdbcutil.JdbcUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

//模拟用户登陆案例
public class LoginUser2 {
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
//    Statement stat=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    try {
        conn = JdbcUtil.getConn();
        String sql="select * from user where username=? and password=?";
//        将sql骨架传过去是为了让服务器编译并确定下来，再编译并确定之后，sql骨架就无法被改变了
        ps=conn.prepareStatement(sql);
//        再将sql语句中的参数发送给服务器
        ps.setString(1,user);
        ps.setString(2,psw);
        rs=ps.executeQuery();//这里不要在传入sql语句
//        stat=conn.createStatement();9100520909
//        String sql="select * from user where username='"+user+"' and password='"+psw+"'";
//        rs = stat.executeQuery(sql);
        if(rs.next() ){
            System.out.println("账号密码正确");
        }else{
            System.out.println("登录失败");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        JdbcUtil.close(conn,ps,rs);
    }
}
}
