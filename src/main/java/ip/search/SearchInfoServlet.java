package ip.search;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.*;

/**
 * Created by LiQingsong on 2018/9/28.
 */
@WebServlet("/searchInfo")
public class SearchInfoServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String info = request.getParameter("info");

       info = findGeoByIp(info);

       response.setContentType("text/html;charset=utf-8");
        Writer out = response.getWriter();
        out.write(info);


    }

    private String findGeoByIp(String ip){
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql:///db?user=root&password=root";
        String sql = "select geo from ips where inet_aton(min)<=inet_aton(?) and inet_aton(max)>=inet_aton(?) ";
        try (Connection connection = DriverManager.getConnection(url);
            PreparedStatement prep = connection.prepareStatement(sql)) {
            prep.setString(1,ip);
            prep.setString(2,ip);
            rs = prep.executeQuery();
            while (rs.next()){
                return rs.getString(1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return "";
    }
}
