package StudentSystem.controller;

import StudentSystem.dao.UserDao;
import StudentSystem.daoimpl.UserDaoImp;
import StudentSystem.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class LoginController{

    private static User user = new User();

    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("user") User user, Model model) {
        UserDao userDao = new UserDaoImp();
        boolean check = userDao.UserCheck(user);
        if(check){
            // 重定向到success的页面
            return "home";
        }else{
            model.addAttribute("error","身份验证失败");
            return "login";
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("login", "user", user);
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public ModelAndView addUser() {
        return new ModelAndView("adduser", "user", user);
    }

    @RequestMapping(value = "/adduser.do", method = RequestMethod.POST)
    public String processAddUser(@ModelAttribute("user") User user, Model model) {
        UserDao userDao = new UserDaoImp();
        boolean check = false;
        if(user.getUsername() != null && user.getPassword() != null && user.getPassword().equals(user.getPasswordvalid()))
        {
            check = userDao.addUser(user);
        }
        if(check){
            // 重定向到success的页面
            return "home";
        }else{
            // 重定向到error的页面
            model.addAttribute("error","用户名已存在");
            return "adduser";
        }
    }
}
