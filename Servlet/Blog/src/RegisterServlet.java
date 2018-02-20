import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "Register",
        urlPatterns = {"/register.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW",value = "success.view"),
                @WebInitParam(name = "ERROR_VIEW",value = "error.view")
        }
)
public class RegisterServlet extends HttpServlet {
    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException{
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取参数
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmedPasswd = request.getParameter("confirmedPasswd");

        //确认注册信息
        List<String> errors = new ArrayList<String>();
        if(isInvalidEmail(email)){
            errors.add("未填写邮件或者邮件格式不正确");
        }

        if(isInvalidPassword(password,confirmedPasswd)){
            errors.add("请确认密码符合格式并再次确认密码");
        }

        UserService userService = (UserService)getServletContext().getAttribute("userService");
        if(userService.isInvalidUsername(username)){
            errors.add("用户名称为空或已经存在");
        }

        String resultPage = ERROR_VIEW;
        if(!errors.isEmpty()){
            request.setAttribute("errors",errors);
        }else{
            resultPage = SUCCESS_VIEW;
            userService.createUserData(email,username,password);
        }
        request.getRequestDispatcher(resultPage).forward(request,response);
    }

    private boolean isInvalidEmail(String email){
        return email == null ||  !email.matches("[_a-z0-9-]"+
                "+([.][_a-z0-9-]+)*@[_a-z0-9-]+([.][_a-z0-9-]+)*$");
    }

    private boolean isInvalidPassword(String password,String confirmedPasswd){
        return password == null || password.length()<6 ||
                password.length()>16|| !password.equals(confirmedPasswd);
    }
}
