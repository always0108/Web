package org.xiyoulinux;

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

    public void startConnect(){
        if(conn == null){
            synchronized (DBConnection.class){
                //加载Properties文件
                Properties properties = new Properties();
                try{
                    //可以使用资源的名称来获取
                    properties.load(Properties.class.getResourceAsStream("/dbProperties"));
                    //必须使用绝对路径
                    //properties.load(new FileInputStream("/home/limeng/git/Web/Maven/connectmysql/src/dbProperties"));
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
}
