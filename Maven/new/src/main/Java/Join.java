import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "Join",
        urlPatterns = {"/join.do"},
        initParams = {
                @WebInitParam(name = "SUCCESS_VIEW",value = "member.jsp"),
                @WebInitParam(name = "ERROR_VIEW",value = "index.jsp")
        }
)
public class Join extends HttpServlet {

    private String SUCCESS_VIEW;
    private String ERROR_VIEW;

    @Override
    public void init() throws ServletException{
        SUCCESS_VIEW = getServletConfig().getInitParameter("SUCCESS_VIEW");
        ERROR_VIEW = getServletConfig().getInitParameter("ERROR_VIEW");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*String username = request.getParameter("name");
        String home = request.getParameter("home");
        String type = request.getParameter("type");
        String phone = request.getParameter("phone");
        */

        List<JSONObject> list = new ArrayList<JSONObject>();
        for(int i=0;i<5;i++){
            JSONObject temp = new JSONObject();
            temp.put("name","李猛");
            temp.put("学号","04163164");
            list.add(temp);
        }
        String str = JSON.toJSONString(list);
        System.out.println(str);




    }

}
