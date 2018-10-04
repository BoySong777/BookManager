package cn.lqs.servlet;

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
@WebServlet("/verifyEmailIsRepeat")
public class VerifyEmailIsRepeat extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("newEmail");
        boolean isNew = DBUtil.verifyEmailIsRepeat(email);
        resp.setContentType("application/text,charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write(String.valueOf(isNew));
    }
}
