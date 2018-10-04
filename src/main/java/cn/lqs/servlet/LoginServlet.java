package cn.lqs.servlet;

import cn.lqs.model.User;
import cn.lqs.util.DBUtil;

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
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = DBUtil.verifyLogin(email,password);

        boolean success = false;
        if(user!=null){
            success = true;
            request.getSession().setAttribute("user",user);
        }
        response.setContentType("application/text;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        writer.write(String.valueOf(success));
    }
}
