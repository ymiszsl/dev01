package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
   @Autowired
   //获取mapper
   private TbUserMapper userDao;

    @Override
    public ResultVO login(String username, String password) {
       ResultVO vo;
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
      //名字
        criteria.andUsernameEqualTo(username);
        //密码
        criteria.andPasswordEqualTo(password);
        //查询
        List<TbUser> users = userDao.selectByExample(example);
        if (users.size()>0){
            vo = new ResultVO(200, "login success!", true, users.get(0));
        } else {
            vo = new ResultVO(0, "登录失败，用户名或密码错误", false, null);
        }


        return vo;
    }
}
