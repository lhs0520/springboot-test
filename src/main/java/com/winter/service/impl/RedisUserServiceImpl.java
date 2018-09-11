package com.winter.service.impl;

import com.winter.enums.PointsTypeEnum;
import com.winter.enums.UserInfoBaseEnums;
import com.winter.mapper.UserMapper;
import com.winter.model.User;
import com.winter.service.RedisUserService;
import com.winter.util.RedisKeyPrefix;
import java.util.concurrent.TimeUnit;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisUserServiceImpl implements RedisUserService{

  private static final Logger log = LoggerFactory.getLogger(RedisUserServiceImpl.class);

  @Resource
  private RedisTemplate redisTemplate;
  @Autowired
  UserMapper userMapper;

  @Override
  public User selectUserById(int id) {
    String key = RedisKeyPrefix.USER + id;
    // 缓存存在
    boolean hasKey = redisTemplate.hasKey(key);
    if (hasKey) { // 从缓存中取
      User user = (User) redisTemplate.opsForValue().get(key);
      log.info("从缓存中获取了用户！");
      return user;
    }
    // 从数据库取，并存回缓存
    User user = userMapper.selectUserList().get(id-1);
    // 放入缓存，并设置缓存时间
    redisTemplate.opsForValue().set(key, user, 600, TimeUnit.SECONDS);
    return user;
  }

  @Override
  public int updateUserById(int id) {
    return 0;
  }

  @Override
  public int deleteUserById(int id) {
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(UserInfoBaseEnums.STATUS_DISABLE.ordinal());
    System.out.println(PointsTypeEnum.fetchDescription("01"));
    System.out.println(PointsTypeEnum.FIRST_PAY_POINTS.name());
  }
}
