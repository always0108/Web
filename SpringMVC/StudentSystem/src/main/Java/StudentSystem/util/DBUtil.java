package StudentSystem.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

    private static DBUtil dbUtil = null;

    private Connection conn = null;

    private DBUtil() {}

    public  static DBUtil getInstance() {
        if(dbUtil == null){
            synchronized (DBUtil.class){
                if(dbUtil == null){
                    dbUtil = new DBUtil();
                }
            }
        }
        return dbUtil;
    }

    public void startConnect(){
        if(conn == null){
            synchronized (DBUtil.class){
                //加载Properties文件
                Properties properties = new Properties();
                try{
                    //可以使用资源的名称来获取
                    properties.load(this.getClass().getClassLoader().getResourceAsStream("/jdbc.properties"));
                }catch(IOException ex){
                    ex.printStackTrace();
                }

                try {
                    Class.forName(properties.getProperty("driver"));
                    conn = DriverManager.getConnection(properties.getProperty("url"),
                            properties.getProperty("username"), properties.getProperty("password"));

                    System.out.println("MySQL connection sucessfully!");
                } catch (SQLException e){
                    e.printStackTrace();
                }catch (ClassNotFoundException ex){
                    ex.printStackTrace();
                }
            }
        }else{
            System.out.println("MySQL connection has been starting！");
        }
    }

    public void stopConnect() {
        if(conn!=null){
            try{
                conn.close();
                conn = null;
                System.out.println("MySQL connection stops sucessfully!");
            }catch (SQLException e){
                e.printStackTrace();
            }
        }else{
            System.out.println("MySQL connection doesn't start");
        }
    }

    public void getResult(){
        try {
            String SQL = "select count(*) totalCount from number";
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(SQL);
            ResultSet result = pstmt.executeQuery();
            int total=0;
            if(result.next()){
                total = result.getInt("totalCount");
            }
            System.out.println("学生总数为： "+total+" 个");
        } catch (SQLException e){
            e.printStackTrace();

        }
    }

    public Connection getConn() {
        return conn;
    }
}
