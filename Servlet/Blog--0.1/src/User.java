import model.Blah;
import model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(
        name = "User",
        urlPatterns = {"/user/*","/user.do"},
        initParams = {
                @WebInitParam(name = "USER_VIEW",value = "/user.jsp") }
)
public class User extends HttpServlet {
    private String USER_VIEW;

    @Override
    public void init() throws ServletException{
        USER_VIEW = getServletConfig().getInitParameter("USER_VIEW");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response,String username) throws ServletException, IOException {
        UserService userService = (UserService)getServletContext().getAttribute("userService");

        if(userService.isUserExisted(username)) {
            Blah blah = new Blah();
            blah.setUsername(username);
            List<Blah> blahs = userService.getBlahs(blah);
            request.setAttribute("blahs", blahs);
        }
        request.setAttribute("username",username);
        request.getRequestDispatcher(USER_VIEW).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getPathInfo().substring(1);
        processRequest(request,response,username);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("user");
        processRequest(request,response,username);
    }
}
