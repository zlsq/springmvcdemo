package com.zlsq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zlsq on 2017/2/5.
 */

//Controller注解,明确地定义该类为处理请求的Controller类
@Controller
public class MainController {
//    RequestMapping()注解:用于定义一个请求映射,value为请求的url,值为/请求首页请求,method指定请求类型为get或post
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
