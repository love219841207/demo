package com.cookie.home.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cookie.sso.service.inter.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")

public class HomeController {
    @Reference
    private TestService testService;

    @RequestMapping("/say")
    public String sayHello(){
        return testService.sayHello("dean");
    }

    @RequestMapping("/hao")
    public String sayhaole(HttpSession session){
        return session.getId();
    }

}
