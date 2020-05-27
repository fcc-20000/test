package cn.bdqn.warehousemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LgoinController {

    @GetMapping("/index")
    public String index() {
        System.out.println("进入主页面");
        return "index";
    }



}
