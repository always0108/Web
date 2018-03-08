package Listener;

import model.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class BlogListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent sce){
        ServletContext context = sce.getServletContext();
        String USERS = sce.getServletContext().getInitParameter("USERS");
        //取得USERS别忘设置
        context.setAttribute("userService",new UserService(USERS));
    }

    public void contextDestroyed(ServletContextEvent sce) {}
}
