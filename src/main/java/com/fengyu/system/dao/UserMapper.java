package com.fengyu.system.dao;

import com.fengyu.system.base.BaseMapper;
import com.fengyu.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by rain on 2017/3/13.
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    // @Select("SELECT * FROM USER WHERE NAME = #{name}")
    // User findByName(@Param("name") String name);
    // List<User> findAllPage();


}
