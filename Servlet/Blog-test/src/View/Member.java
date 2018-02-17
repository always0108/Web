package View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "member",urlPatterns ={"/member.view"})
public class Member extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta content='text/html;charset=UTF-8' http-equiv='content-type'>");
        out.println("<title>会员主页</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>会员 "+request.getParameter("username")+" ，欢迎登录！ </h1>");
        out.println("</body>");
        out.println("</html>");
    }

}
