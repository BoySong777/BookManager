package cn.lqs.util;

import cn.lqs.model.User;
import com.mysql.jdbc.Driver;
import org.jasypt.util.password.StrongPasswordEncryptor;

import java.sql.*;

/**
 * Created by LiQingsong on 2018/9/29.
 */
public class DBUtil {

    private static String url = "jdbc:mysql:///?user=root&password=root";


    static {
        try {
            new Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User verifyLogin(String email, String password) {
        User user = null;
        boolean result = false;
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "select * from db.user " +
                    " where email = '" + email + "'";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                //验证密码
                StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
                if(encryptor.checkPassword(password,rs.getString("password"))){
                    System.out.println("test");
                    user = new User();
                    user.setId(rs.getInt("id"));
                    user.setEmail(rs.getString("email"));
                    user.setUsername(rs.getString("username"));
                }
            }
            close(conn, stat, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static boolean verifyEmailIsRepeat(String email) {
        boolean result = true;
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "select email from db.user " +
                    " where email = '" + email + "' ";
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            if (rs.next()) {
                result = false;
            }
            close(conn, stat, rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static int update(String sql, Object[] objects) {
        int result = 0;
        try {
            Connection conn = DriverManager.getConnection(url);

            PreparedStatement stat = conn.prepareStatement(sql);
            int i = 0;
            for (Object obj : objects
                    ) {
                stat.setObject((++i), obj);
            }

             result = stat.executeUpdate();
            close(conn, stat, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    private static void close(Connection conn,Statement state,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (state!=null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    private static void close(Connection conn,PreparedStatement state,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (state!=null){
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}

