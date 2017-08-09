package com.fengyu.system.dao;

import com.fengyu.system.base.BaseMapper;
import com.fengyu.system.entity.SystemMenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 自动生成代码
 * Created by HF on 2017-8-8 22:26:54.
 */
@Mapper
public interface SystemMenuMapper extends BaseMapper<SystemMenuEntity>{

   /**
    * 更新状态 id 集合in更新
    * @param status 被更新状态
    * @param ids id数组
    */
    void batchUpdateState(@Param("status") String status, @Param("ids") String [] ids);
}




