package Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;

@WebServlet(name = "Message",urlPatterns={"/message.do"})
public class Message extends HttpServlet {

    private final String LOGIN_VIEW = "index.jsp";
    private final String SUCCESS_VIEW = "member.view";
    private final String ERROR_VIEW = "member.view";
    private final String USERS = "/home/limeng/git/Web/Servlet/Blog-test/Data";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("login") == null){
            response.sendRedirect(LOGIN_VIEW);
            return;
        }

        request.setCharacterEncoding("UTF-8");
        String blabla = request.getParameter("blabla");
        if(blabla != null && blabla.length() !=0){
            if(blabla.length()<140) {
                String username = (String) request.getSession().getAttribute("login");
                addMessage(username, blabla);
                response.sendRedirect(SUCCESS_VIEW);
            }else{
                request.getRequestDispatcher(ERROR_VIEW).forward(request,response);
            }
        }else{
            response.sendRedirect(ERROR_VIEW);
        }
    }

    private void addMessage(String username,String blabla) throws IOException{
        String file = USERS + "/" + username + "/" + new Date().getTime() + ".txt";
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
        writer.write(blabla);
        writer.close();
    }
}
