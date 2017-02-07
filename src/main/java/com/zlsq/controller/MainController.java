package com.zlsq.controller;

import com.zlsq.model.UserEntity;
import com.zlsq.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by zlsq on 2017/2/5.
 */

//Controller注解,明确地定义该类为处理请求的Controller类
@Controller
public class MainController {
    //自动装配数据库接口，不需要再写原始的Connection来操作数据库.
    //自动装配：相当于数据库操作的极简化，只要定义了就可以直接进行数据库操作，
        // 不用再去管开启连接、关闭连接等问题
    @Autowired
    UserRepository userRepository;


    //    RequestMapping()注解:用于定义一个请求映射,value为请求的url,
    // 值为/请求首页请求,method指定请求类型为get或post
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUser(ModelMap modelMap) {
        //查询表中所有记录
        List<UserEntity> userList = userRepository.findAll();

        //将所有记录传递给返回的jsp，放在userList中
        modelMap.addAttribute("userList", userList);

        //返回pages目录下的admin/user.jsp页面
        return "admin/users";
    }

    //get请求，访问添加用户页面
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser(){
        //转到 admin/addUser.jsp页面
        return "admin/addUser";
    }

    //post请求，处理添加用户请求,并重定向到用户管理界面
    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") UserEntity userEntity) {
            //注意此处,post请求传来的是一个UserEntity对象，里面包含了该用户的信息
            //通过@ModelAttribute()注解可以获取传递过来的'user',并创建这个对象

            //数据库中添加一个用户，该步暂停不会刷新缓存
            //userRepository.save(userEntity);

        //数据库中添加一个用户，并立即刷新缓存
        userRepository.saveAndFlush(userEntity);

        //重定向到用户管理页面，方法为redirect:url
        return "redirect:/admin/users";
    }

    //查看用户详情
    //@PathVariable可以收集url中的变量，需匹配的变量用{}括起来
    //例如：访问localhost：8080/admin/users/show/1,将匹配 id = 1
    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
        UserEntity userEntity = userRepository.findOne(userId);

        // 传递给请求页面
        modelMap.addAttribute("user", userEntity);
        return "admin/userDetail";
    }


}




















