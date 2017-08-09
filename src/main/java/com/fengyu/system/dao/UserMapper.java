package com.fengyu.system.dao;

import com.fengyu.system.base.BaseMapper;
import com.fengyu.system.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
import org.apache.ibatis.annotations.Mapper;
 * Created by rain on 2017/3/13.
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    // @Select("SELECT * FROM USER WHERE NAME = #{name}")
    // User findByName(@Param("name") String name);
    // List<User> findAllPage();

    // @Update("update ts_user set status = #{status} where id in ( #{ids} )")
    void batchUpdateState(@Param("status") String status, @Param("ids") String [] ids);

}
