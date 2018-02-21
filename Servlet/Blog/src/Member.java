import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet(
        name = "Member",
        urlPatterns = {"/member.view"},
        initParams = {
                @WebInitParam(name = "LOGIN_VIEW",value = "index.jsp")
        }
)
public class Member extends HttpServlet {

    private String LOGIN_VIEW;

    @Override
    public void init() throws ServletException{
        LOGIN_VIEW = getServletConfig().getInitParameter("LOGIN_VIEW");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        if(request.getSession().getAttribute("login") == null){
            response.sendRedirect(LOGIN_VIEW);
            return;
        }
        String username = (String)request.getSession().getAttribute("login");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<meta content='text/html;charset=UTF-8' http-equiv='content-type'>");
        out.println("<title>会员主页</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>会员 "+username+" ，欢迎登录！ </h1>");
        out.println("<a href='logout.do?username='"+ username +"'>注销"+username+"</a> <br> <br>");
        out.println("<div>");
        out.println("<form method='post' action='message.do'>");
        out.println("分享新鲜事...<br>");
        String blabla = request.getParameter("blabla");
        if(blabla==null){
            blabla="";
        }else{
            out.println("<span style='color: red'>信息要在140字内</span><br>");
        }
        out.println("<textarea cols='60' rows='4' name='blabla'>"+blabla+"</textarea>");
        out.println("<br> <input type='submit' value='发送' name='send'> <br> <br>");

        UserService userService = (UserService)getServletContext().getAttribute("userService");
        Map<Date,String> messages = userService.readMessage(username);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        out.println("<h3>动态</h3> <hr>");
        for(Date date:messages.keySet()){
            out.println("<tr><td style='vertical-align: top;'>");
            out.println("<span style='color: red" +
                    "'>"+
                    username+"</span> <br>");
            out.println(messages.get(date)+"<br>");
            out.println(df.format(date));
            out.println("<a href='delete.do?message="+date.getTime()
                    +"'>删除</a>");
            out.println("<hr></td></tr>");
        }
        out.println("</body>");
        out.println("</html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
