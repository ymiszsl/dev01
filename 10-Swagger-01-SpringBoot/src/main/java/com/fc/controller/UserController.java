package com.fc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
//分组
@Api(tags = "用户模块",description = "用户的所有操作")
public class UserController {
    //是佛隐藏，值，分组
    @ApiOperation(value = "查询所有的用户",tags = "select")
    @GetMapping("findAll")
    public  String findAll(){
        return "user findAll";
    }
    @ApiOperation(value = "根据id查询对应的用户", tags = "select")
    @GetMapping("findById")
    //allowableValues好多方法
    public  String findById(@ApiParam(allowableValues = "range(1,5)",required = true) @RequestParam(defaultValue = "1") Integer id){
        System.out.println("获取到的id：" + id);
        return "user findById:" + id;
    }
    @ApiOperation(value = "分页查询用户",tags = "select")
    @GetMapping("findByPage")
    //定义参数单个示例example
    public  String findByPage(@ApiParam(defaultValue = "分页参数：当前页",example = "1")
        @RequestParam(defaultValue = "1") Integer pageNum,
        @ApiParam(defaultValue = "分页参数：每页显示多少条数据", example = "5")
        @RequestParam(defaultValue = "5") Integer pageSize) {
            return "findByPage:当前页：" + pageNum + ",每页显示多少条数据：" + pageSize;
        }
@ApiOperation(value ="添加用户",tags = "operator")
    @PostMapping("add")
//ApiParam和RequestParam一起
//required定义是佛必传，必须有这RequestParam进行json转换
    public  String add(@ApiParam(name = "username",value = "用户名必选",required = true)@RequestParam String username,
                       @ApiParam("用户密码，必选") @RequestParam String password){
    return "user add:" + username + password;
}
    @ApiOperation(value = "删除用户", tags = "operator")
    @DeleteMapping("delete")
    public String delete() {
        return "user delete";
    }
//ApiOperation类ApiParam方法

    @ApiOperation(value = "修改用户", tags = "operator")
    @PutMapping("update")
    public String update() {
        return "user update";
    }
}
