package com.fc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("report")
public class ReportController {
    @GetMapping("info")
    public ModelAndView info(ModelAndView mv){
      //设置请求域对象
       mv.addObject("menu_page","report");
        mv.addObject("changePage","/report/info.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
}
