package Util;

import Util.DBConnection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@javax.servlet.annotation.WebListener
public class WebListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce){
        //读取数据库连接相关参数
        ServletContext context = sce.getServletContext();
        String driver = sce.getServletContext().getInitParameter("driver");
        String url = sce.getServletContext().getInitParameter("url");
        String username = sce.getServletContext().getInitParameter("username");
        String password = sce.getServletContext().getInitParameter("password");
        //连接数据库
        DBConnection dbConnection = DBConnection.getInstance();
        dbConnection.startConnect(driver,url,username,password);
        dbConnection.SQLexecte("CREATE TABLE IF NOT EXISTS prizelist select * from number");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DBConnection dbConnection = DBConnection.getInstance();
        dbConnection.SQLexecte("DROP TABLE IF EXISTS prizelist");
        dbConnection.stopConnect();
    }
}
