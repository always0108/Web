import model.Blah;
import model.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "Login",
        urlPatterns = {"/login.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW",value = "member.jsp"),
                @WebInitParam(name = "ERROR_VIEW",value = "index.jsp")
        }
    )
public class Login extends HttpServlet {

    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException{
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserService userService = (UserService)getServletContext().getAttribute("userService");

        String resultpage;
        if (userService.checkLogin(username, password)) {
            request.getSession().setAttribute("login",username);
            resultpage = SUCCESS_VIEW;
            //登录成功读取自己的动态
            Blah blah = new Blah();
            blah.setUsername(username);

            List<Blah> blahs = userService.getBlahs(blah);
            request.setAttribute("blahs", blahs);
        } else {
            request.setAttribute("error","名称或者密码错误");
            resultpage = ERROR_VIEW;
        }
        request.getRequestDispatcher(resultpage).forward(request, response);
    }

}
