package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
//不用哪一个是害怕跳过视图解析器
@RequestMapping("user")
public class UserController {
    @Autowired
    //自己弄得
    private UserService userService;
    @PostMapping("login")
    //直接传入东西实现传入的是一些基本的按照步骤
    public ModelAndView login(TbUser user,
                              Integer remember,
                              HttpSession session,
                              HttpServletResponse response,
                              ModelAndView mv){
       ResultVO vo= userService.login(user.getUsername(),user.getPassword());
       if (vo.getCode()==0){
           //设置请求域对象resultInfo，
           mv.addObject("resultInfo",vo);
         //转发
           mv.setViewName("forward:/login.jsp");
       }else {
           //将查询出来的User对象存入session域对象中
         session.setAttribute("user",vo.getData());
           Cookie cookie;

           if (remember!=null&&remember==1){
               cookie = new Cookie("JSESSIONID", session.getId());

               cookie.setMaxAge(30 * 60);
           } else {
               cookie = new Cookie("JSESSIONID", null);

               cookie.setMaxAge(-1);
           }
           response.addCookie(cookie);

           mv.setViewName("forward:/index.jsp");
           }
        return mv;
    }
}
