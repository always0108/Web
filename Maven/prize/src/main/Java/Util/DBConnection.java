package Util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static DBConnection dbConnection = null;

    private Connection conn = null;

    private DBConnection() {}

    public  static DBConnection getInstance() {
        if(dbConnection == null){
            synchronized (DBConnection.class){
                if(dbConnection == null){
                    dbConnection = new DBConnection();
                }
            }
        }
        return dbConnection;
    }

    public void startConnect(String driver,String url,String username,String password){
        if(conn == null){
            String add = "?useUnicode=true&characterEncoding=utf-8&useSSL=false";
            synchronized (DBConnection.class){
                try {
                    Class.forName(driver);
                    conn = DriverManager.getConnection(url,
                            username, password);
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

    public void SQLexecte(String SQL){
        try {
            PreparedStatement pstmt = null;
            pstmt = conn.prepareStatement(SQL);
            pstmt.execute();
            System.out.println("sucess");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
