package com.cookie.sso.web;

import com.cookie.framework.base.PageBean;
import com.cookie.sso.mapper.StudentMapper;
import com.cookie.sso.model.Student;
import com.cookie.sso.service.impl.StudentService;
import com.cookie.sso.service.inter.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;
    @RequestMapping("/")
    public String save(){
        userService.save("dean");
        String name = userService.getById(2);
        userService.deleteById(1);
        return "1";
    }

    @RequestMapping("/dean")
    public String dean(){
        PageBean<Student> page = studentService.getPageBeanBySelectAll(0,2);
      //  System.out.print(name);
        return "2";
    }

}
