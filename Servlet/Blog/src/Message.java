import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "Message",
        urlPatterns = {"/message.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW",value = "member.view"),
                @WebInitParam(name = "ERROR_VIEW",value = "member.view"),
                @WebInitParam(name = "LOGIN_VIEW",value = "index.jsp")
        })

public class Message extends HttpServlet {

    private String SUCCESS_VIEW;
    private String ERROR_VIEW;
    private String LOGIN_VIEW;

    @Override
    public void init() throws ServletException{
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
        LOGIN_VIEW = getServletConfig().getInitParameter("LOGIN_VIEW");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getSession().getAttribute("login") == null){
            response.sendRedirect(LOGIN_VIEW);
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String blabla = request.getParameter("blabla");
        UserService userService = (UserService)getServletContext().getAttribute("userService");
        if(blabla != null && blabla.length() !=0){
            if(blabla.length()<140) {
                String username = (String) request.getSession().getAttribute("login");
                userService.addMessage(username, blabla);
                response.sendRedirect(SUCCESS_VIEW);
            }else{
                request.getRequestDispatcher(ERROR_VIEW).forward(request,response);
            }
        }else{
            response.sendRedirect(ERROR_VIEW);
        }
    }
}
