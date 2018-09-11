package com.winter.mapper;

import com.winter.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectUserList();
}