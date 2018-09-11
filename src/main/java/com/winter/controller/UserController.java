package com.winter.controller;

import com.winter.model.User;
import com.winter.service.RedisUserService;
import com.winter.service.impl.UserServiceImpl;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private UserServiceImpl userService;
  @Autowired
  private RedisUserService redisUserService;

  @ResponseBody
  @RequestMapping("hello")
  public List<Map<String, Object>> hello() {
    List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT id,name FROM user ", new Object[]{});
    return list;
  }

  @ResponseBody
  @RequestMapping("/userList/{pageNum}/{pageSize}")
  public String selectUserList(@PathVariable int pageNum, @PathVariable int pageSize){
    return userService.selectUserList(pageNum,pageSize);
  }

  @RequestMapping("hello/{pageNum}/{pageSize}")
  public String hello(Model model ,@PathVariable int pageNum, @PathVariable int pageSize){
//    System.out.println(pageNum + "#" + pageSize);
    model.addAttribute("info",userService.selectUserList2(pageNum,pageSize));
    return "index";
  }

  @RequestMapping("index")
  public String hello2(Model model){
//    System.out.println(pageNum + "#" + pageSize);
    model.addAttribute("info",redisUserService.selectUserById(1));
    return "index";
  }

  @ResponseBody
  @RequestMapping("userList2/{pageNum}/{pageSize}")
  public List<User> selectUserListForAjax(@PathVariable int pageNum, @PathVariable int pageSize){
    return userService.selectUserList2(pageNum,pageSize);
  }
}
