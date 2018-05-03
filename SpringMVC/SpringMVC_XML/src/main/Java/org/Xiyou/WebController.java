package org.Xiyou;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
    //访问静态资源需要配置
    @RequestMapping(value = "/resources/staticPage", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:/resources/final.html";
    }
}