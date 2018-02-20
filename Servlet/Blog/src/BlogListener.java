import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BlogListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent sce){
        ServletContext context = sce.getServletContext();
        String USERS = sce.getServletContext().getInitParameter("USERS");
    }

    public void contextDestroyed(ServletContextEvent sce) {}
}
