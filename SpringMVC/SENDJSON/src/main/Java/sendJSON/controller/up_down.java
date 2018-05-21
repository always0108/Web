package sendJSON.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sendJSON.model.User;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.CookieStore;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class up_down {

    //展示表单
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public Object student() {
        ArrayList<User> result = new ArrayList<>();
        result.add(new User("李猛","男"));
        result.add(new User("胡旭东","男"));
        result.add(new User("李兆鹏","男"));
        return result;
        //return new Date();
    }

    //展示表单
    @RequestMapping(value = "/getcookie", method = RequestMethod.GET)
    @ResponseBody
    public void getcookie(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().setAttribute("user",new User("limeng","male"));
        Cookie cookie = new Cookie("name","okok");
        response.addCookie(cookie);
    }

    @RequestMapping(value = "/getcookie1", method = RequestMethod.GET)
    @ResponseBody
    public void getcookie1(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute("user");
        System.out.println("Session:\n"+user.getUsername()+"\t"+user.getSex());
        System.out.println();

        Cookie[] cookies= request.getCookies();
        System.out.println("Cookies:");
        for(int i = 0;i<cookies.length;i++){
            System.out.println(cookies[i].getName()+"\t"+cookies[i].getValue());
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public void login(@ModelAttribute() User user) {
        System.out.println("username:"+user.getUsername());
        System.out.println("password:"+user.getPassword());
    }
}
