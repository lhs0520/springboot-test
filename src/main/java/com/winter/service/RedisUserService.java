package com.winter.service;

import com.winter.model.User;

public interface RedisUserService {

  User selectUserById(int id);

  int updateUserById(int id);

  int deleteUserById(int id);
}
