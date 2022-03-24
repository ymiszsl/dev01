package com.fc.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class pageServlet extends HttpServlet
{
   StudentServiceImpl studentService = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//获取前端的请求参数
        String  parameter = req.getParameter("pageNo");

        //假设第一次
        int pageNo =1;

if (parameter!=null){
    //包装类strig转int
    pageNo=Integer.parseInt(parameter);
}
//每页显示多少条
        int pageSize = 5;

PageInfo<Student> pageInfo = studentService.getPageInfo(pageNo,pageSize);
  //发送到前端
        req.getRequestDispatcher("page.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
