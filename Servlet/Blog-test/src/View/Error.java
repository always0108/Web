package View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "error",urlPatterns = {"/error.view"})
public class Error extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html>");

        out.println("<head>");
        out.println("<meta content='text/html;charset=UTF-8' http-equiv='content-type'>");
        out.println("<title>新增会员失败</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>新增会员失败</h1>");
        out.println("<ul style='color: rgb(255,0,0);'>");
        List<String> errors = (List<String>)request.getAttribute("errors");
        for(String error : errors){
            out.println("<li>"+error+"</li>");
        }
        out.println("</ul>");
        out.println("<a href='register.jsp'>返回注册界面</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
