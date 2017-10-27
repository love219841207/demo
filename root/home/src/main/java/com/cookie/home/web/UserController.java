package com.cookie.home.web;


import com.alibaba.dubbo.config.annotation.Reference;
import com.cookie.sso.service.inter.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Reference
    private UserService userService;

    @RequestMapping("/say")
    public String sayHello(){
        userService.save("dean");
        String name = userService.getById(2);
        userService.deleteById(1);
        return "hello";
    }


}
