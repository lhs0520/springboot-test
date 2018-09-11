package com.winter.service;

import com.winter.MybatisApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MybatisApplication.class)
public class UserServiceTest {
  @Autowired
  private UserService userService;

  @Test
  public void selectUserListTest(){
    String list = userService.selectUserList(2,1);

    Assert.assertNotNull(list);
  }

}