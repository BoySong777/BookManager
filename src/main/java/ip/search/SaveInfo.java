package ip.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by LiQingsong on 2018/9/28.
 */
public class SaveInfo {

    private static  final String FILE = "data/ip.txt";
    private static List<IP> ips;

    public static void main(String[] args) {
        SaveInfo saveInfo = new SaveInfo();
        saveInfo.parse();
        Long start = System.currentTimeMillis();
        saveInfo.dump();
        System.out.println("time:"+(System.currentTimeMillis()-start));
    }

    public void parse(){
        ips = new LinkedList<IP>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))){
            String line;
            String max,min,geo;
            while((line=bufferedReader.readLine()) != null){
                min = line.split("\\s+")[0];
                max = line.split("\\s+")[1];
                geo = line.replaceAll(min+"\\s+"+max,"").trim();
                ips.add(new IP(min,max,geo));
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void dump(){
        Connection conn = null;
        PreparedStatement prep = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/db?user=root&password=root";
        try {
            conn = DriverManager.getConnection(url);
            conn.setAutoCommit(false);
            String sql = "INSERT into ips value(null,?,?,?)";
            prep = conn.prepareStatement(sql);

            for (IP ip : ips) {
                prep.setString(1,ip.getMin());
                prep.setString(2,ip.getMax());
                prep.setString(3,ip.getGeo());
                prep.addBatch();
            }
            prep.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(prep!=null){
            try {
                prep.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}

class IP{

    private String min;
    private String max;
    private String geo;

    public IP() {
    }

    public IP(String min, String max, String geo) {
        this.min = min;
        this.max = max;
        this.geo = geo;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "IP{" +
                "min='" + min + '\'' +
                ", max='" + max + '\'' +
                ", geo='" + geo + '\'' +
                '}';
    }
}
