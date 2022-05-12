package com.fc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//注意这里不能用@RestController注解因为会直接跳过视图解析器
//如果使用了@RestController注解将会跳过视图解析器
@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
@RequestMapping("test")
public  String test(HttpServletRequest request){
    request.setAttribute("data","请求域对象设置参数到Thymeleaf中");
    return "index";
}
    @RequestMapping("test1")
    public  ModelAndView test1(ModelAndView mv){
        mv.addObject("data","mo");
//转发传递上去
        mv.setViewName("index");
        return mv;
    }
    @RequestMapping("test2")
    public  String test2(Model mv){
        mv.addAttribute("data","m");
        return "index";
    }
}
