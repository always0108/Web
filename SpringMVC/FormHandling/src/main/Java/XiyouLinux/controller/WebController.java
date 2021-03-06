package XiyouLinux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    //访问静态资源需要配置
    @RequestMapping(value = "/resources/staticPage", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:/resources/final.html";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String redirect2() {
        return "redirect:finalPage";
    }

    @RequestMapping(value = "/finalPage", method = RequestMethod.GET)
    public String finalPage() {

        return "final";
    }
}