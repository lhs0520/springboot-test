package com.winter.service;

import com.winter.model.User;
import java.util.List;

public interface UserService {

  public String selectUserList(int pageNum, int pageSize);

  public List<User> selectUserList2(int pageNum, int pageSize);
}
