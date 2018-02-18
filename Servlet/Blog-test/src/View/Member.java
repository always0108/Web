package View;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

@WebServlet(name = "member",urlPatterns ={"/member.view"})
public class Member extends HttpServlet {

    private final String LOGIN_VIEW = "index.jsp";
    private final String USERS = "/home/limeng/git/Web/Servlet/Blog-test/Data";

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

        Map<Date,String> messages = readMessage(username);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        for(Date date:messages.keySet()){
            out.println("<tr><td style='vertical-align: top;'>");
            out.println(username+"<br>");
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

    //过滤.txt文件名
    private class TxtFilenameFilter implements FilenameFilter{
        @Override
        public boolean accept(File dir,String name){
            return  name.endsWith(".txt");
        }
    }

    private TxtFilenameFilter filenameFilter = new TxtFilenameFilter();

    //TreeMap排序用,因为希望信息的日期越近的越靠前显示
    private class DateComparator implements Comparator<Date>{
        @Override
        public int compare(Date d1,Date d2){
            return -d1.compareTo(d2);
        }
    }

    private DateComparator comparator = new DateComparator();

    private Map<Date,String> readMessage(String username) throws IOException{
        File border = new File(USERS+"/"+username);
        String[] txts = border.list(filenameFilter);

        Map<Date,String> messages = new TreeMap<Date, String>(comparator);
        for(String txt: txts){
            BufferedReader reader = new BufferedReader(new InputStreamReader
                    (new FileInputStream(USERS+"/"+username+"/"+txt),"UTF-8"));
            String text = null;
            StringBuilder builder = new StringBuilder();
            while ((text = reader.readLine() )!= null){
                builder.append(text);
            }
            Date date = new Date(Long.parseLong(txt.substring(0,txt.indexOf(".txt"))));
            messages.put(date,builder.toString());
        }
        return  messages;
    }




}
