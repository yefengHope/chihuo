package com.fengyu.system.dao;

import com.fengyu.system.base.BaseMapper;
import com.fengyu.system.entity.UserAndRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by HanFeng on 2017/7/26.
 */
@Mapper
public interface UserAndRoleMapper extends BaseMapper<UserAndRoleEntity> {

    void batchUpdateState(@Param("status") String status, @Param("ids") String [] ids);
}
