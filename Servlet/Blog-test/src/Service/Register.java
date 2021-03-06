package Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="register",urlPatterns={"/register.do"})
public class Register extends HttpServlet {
    private final String SUCCESS_VIEW = "success.view";
    private final String ERROR_VIEW = "error.view";
    private final String USERS = "/home/limeng/git/Web/Servlet/Blog-test/Data";

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
        if(isInvalidUsername(username)){
            errors.add("用户名称为空或已经存在");
        }
        if(isInvalidPassword(password,confirmedPasswd)){
            errors.add("请确认密码符合格式并再次确认密码");
        }
        String resultPage = ERROR_VIEW;
        if(!errors.isEmpty()){
            request.setAttribute("errors",errors);
        }else{
            resultPage = SUCCESS_VIEW;
            createUserData(email,username,password);
        }
        request.getRequestDispatcher(resultPage).forward(request,response);
    }

    private boolean isInvalidEmail(String email){
        return email == null ||  !email.matches("[_a-z0-9-]"+
                "+([.][_a-z0-9-]+)*@[_a-z0-9-]+([.][_a-z0-9-]+)*$");
    }

    private boolean isInvalidUsername(String username){
        for(String file:new File(USERS).list()){
            if(file.equals(username)){
                return true;
            }
        }
        return false;
    }

    private boolean isInvalidPassword(String password,String confirmedPasswd){
        return password == null || password.length()<6 ||
                password.length()>16|| !password.equals(confirmedPasswd);
    }

    private void createUserData(String email,String username,
                                String password) throws IOException{
        File userhome = new File(USERS + "/" + username);
        userhome.mkdir();
        BufferedWriter writer = new BufferedWriter(new FileWriter(userhome+"/profile"));
        writer.write(email + "\t" + password);
        writer.close();
    }
}
