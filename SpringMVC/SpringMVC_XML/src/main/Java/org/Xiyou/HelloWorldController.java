package org.Xiyou;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(Model model) {

        model.addAttribute("greeting", "Hello Spring MVC, I am so tired to do this !");

        return "helloworld";//标示用于渲染输出的视图名

    }

}