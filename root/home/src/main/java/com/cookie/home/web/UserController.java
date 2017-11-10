package com.cookie.home.web;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.cookie.framework.base.PageBean;
import com.cookie.home.util.CustomPage;
import com.cookie.sso.model.SysUser;
import com.cookie.sso.service.inter.SysUserService;
import com.cookie.sso.service.inter.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/user")
@Controller
public class UserController {
   /* @Reference
    private UserService sysUserService;*/
    @Reference
    private SysUserService userService;
/*
    @RequestMapping("/say")
    public String sayHello(HttpServletRequest request){
        sysUserService.save("dean");
        request.getSession().setAttribute("dean","1");
        String name = sysUserService.getById(2);
        sysUserService.deleteById(1);
        return "hello";
    }*/

    // 跳转到用户管理页面
    @RequestMapping(value = "userPage")
    public String userPage(String edit, Model modle) {
        // edit判断是否编辑成功
        modle.addAttribute("edit", "false");
        return "user/user";
    }
/*
    // 跳轉到編輯頁面edit
    @RequestMapping(value = "editPage/{Id}")
    public String editPage(@PathVariable("Id") String Id, Model model) {
        if (Id.equals("add")) {
        } else {
            SysUser user = sysUserService.selectById(Id);
            model.addAttribute("user", user);
        }
        return "user/edit";
    }

    // 增加和修改
    @RequestMapping(value = "edit")
    public String edit(SysUser user,String isEffective, Model model) {
        if(isEffective==null||isEffective==""){
            user.setStatus("0");
        }else{
            user.setStatus("1");
        }
        if (sysUserService.insertOrUpdate(user)) {
            return "forward:userPage?edit=true";
        } else {
            return "forward:userPage?edit=false";
        }
    }
*/
    // 用户列表分页json
    @RequestMapping(value = "getUserListWithPager")
    @ResponseBody
    public String getUserListWithPager() {
       /* Wrapper<SysUser> wrapper = new EntityWrapper<SysUser>();
        String keyWords = page.getKeywords();
        if (keyWords != null && keyWords != "")
            wrapper.like("nickname", keyWords);*/
        PageBean<SysUser> pageList = userService.selectForPage();
        CustomPage<SysUser> customPage = new CustomPage<SysUser>(pageList);
        return JSON.toJSONString(customPage);
    }

    // 刪除用户
    @RequestMapping(value = "delete")
    @ResponseBody
    public String delete(@RequestParam(value = "ids[]") String[] ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            userService.deleteBatchIds(Arrays.asList(ids));
            resultMap.put("flag", true);
            resultMap.put("msg", "刪除成功！");
        } catch (Exception e) {
            resultMap.put("flag", false);
            resultMap.put("msg", e.getMessage());
        }
        return JSON.toJSONString(resultMap);
    }/*
*//*
    // 跳转到在线用户管理页面
    @RequestMapping(value = "onlineUserPage")
    public String onlineUserPage() {
        return "user/onlineUser";
    }

    // 在线用户列表json
    @RequestMapping(value = "onlineUsers")
    @ResponseBody
    public String OnlineUsers(FrontPage<UserOnlineBo> frontPage) {
        Page<UserOnlineBo> pageList = sysUserService.getPagePlus(frontPage);
        CustomPage<UserOnlineBo> customPage = new CustomPage<UserOnlineBo>(pageList);
        return JSON.toJSONString(customPage);
    }*//*
*/
    // 强制踢出用户
   /* @RequestMapping(value = "kickout")
    @ResponseBody
    public String kickout(@RequestParam(value = "ids[]") String[] ids) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            for (String sessionId : ids) {
                sysUserService.kickout(sessionId);
            }
            resultMap.put("flag", true);
            resultMap.put("msg", "强制踢出成功！");
        } catch (Exception e) {
            resultMap.put("flag", false);
            resultMap.put("msg", e.getMessage());
        }
        return JSON.toJSONString(resultMap);
    }*/

}
