import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name ="success",urlPatterns = {"/success.view"})
public class Success extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");

        out.println("<head>");
        out.println("<meta content='text/html;charset=UTF-8' http-equiv='content-type'>");
        out.println("<title>新增会员失败</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>会员 "+request.getParameter("username")+" 注册成功</h1>");
        out.println("<a href='index.jsp'>返回首页登录</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
