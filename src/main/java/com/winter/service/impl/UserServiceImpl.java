package com.winter.service.impl;

import com.github.pagehelper.PageHelper;
import com.winter.mapper.UserMapper;
import com.winter.model.User;
import com.winter.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  UserMapper userMapper;

  @Override
  public String selectUserList( int pageNum, int pageSize){
    PageHelper.startPage(pageNum,pageSize);
    List<User> list = userMapper.selectUserList();
    String resultMsg = null;
    for (User user : list){
      if(resultMsg == null){
        resultMsg = user.toString();
      }else{
        resultMsg = resultMsg + "<pre></pre>" + user.toString();
      }
    }
    return resultMsg;
  }

  public List<User> selectUserList2(int pageNum, int pageSize){
    PageHelper.startPage(pageNum,pageSize);
    return userMapper.selectUserList();
  }

}
