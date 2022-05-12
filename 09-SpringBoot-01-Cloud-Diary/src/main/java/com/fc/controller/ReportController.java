package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.entity.TbUser;
import com.fc.service.ReportService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @GetMapping("info")
    public ModelAndView info(ModelAndView mv){
      //设置请求域对象
       mv.addObject("menu_page","report");
        mv.addObject("changePage","/report/info.jsp");
        mv.setViewName("forward:/index.jsp");
        return mv;
    }
    @GetMapping("month")
    @ResponseBody
    public ResultVO getMonth(HttpSession session){
        //先获取user
        TbUser user = (TbUser) session.getAttribute("user");
      //根据id对象弄出来
        Map<String,Object> data = reportService.getNoteCountByMonth(user.getId());
       //json形式，这个是为了弄后面实现的东西
        ResultVO vo = new ResultVO();
        if (data!=null){
            //Map作为data进行返回
            vo.setData(data);
            vo.setCode(1);
        }
        return vo;
    }
    @GetMapping("location")
    @ResponseBody
    public  ResultVO getLocation(HttpSession session){
        TbUser user = (TbUser) session.getAttribute("user");
     //这个不需要NoteVo和ResultVo
      List<TbNote> notes= reportService.getLocation(user.getId());
        ResultVO vo = new ResultVO();
        if (notes!=null&&notes.size()>0){
            vo.setCode(1);
            vo.setSuccess(true);
            vo.setData(notes);
        }
        return vo;
    }
}
