import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet(
        name = "Delete",
        urlPatterns = {"/delete.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW",value = "member.view"),
                @WebInitParam(name = "LOGIN_VIEW",value = "index.jsp")
        }
)
public class Delete extends HttpServlet {
    private String SUCCESS_VIEW;
    private String LOGIN_VIEW;

    @Override
    public void init() throws ServletException{
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        LOGIN_VIEW = getServletConfig().getInitParameter("LOGIN_VIEW");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("login") == null){
            response.sendRedirect(LOGIN_VIEW);
            return;
        }

        String username=(String)request.getSession().getAttribute("login");
        String message = request.getParameter("message");
        UserService userService = (UserService)getServletContext().getAttribute("userService");
        userService.deleteMessage(username,message);
        response.sendRedirect(SUCCESS_VIEW);
    }
}
