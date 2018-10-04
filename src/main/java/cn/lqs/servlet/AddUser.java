package cn.lqs.servlet;

import cn.lqs.util.DBUtil;
import org.jasypt.util.password.StrongPasswordEncryptor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by LiQingsong on 2018/9/29.
 */
@WebServlet("/addUser")
public class AddUser extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        resp.setContentType("application/text;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        //加密
        StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
        password = encryptor.encryptPassword(password);
        String sql = "insert into db.user values(null,?,?,?)";
        int result = DBUtil.update(sql,new Object[]{email,username,password});
        if (result>0){
            writer.write("success");
        }else{
            writer.write("failure");
        }
    }
}
