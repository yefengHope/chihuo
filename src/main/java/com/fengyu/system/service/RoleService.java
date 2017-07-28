package com.fengyu.system.service;


import com.fengyu.system.entity.RoleEntity;
import com.fengyu.system.entity.UserEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/7/3 15:50 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public interface RoleService {

    List<RoleEntity> getRoles(String userId);

    /**
     * 实现spring security 认证方法
     * @param loginId       用户id
     * @param domainStr     security domain
     * @param permissionStr security permission
     * @return boolean
     */
    boolean authorized(String loginId,String domainStr,String permissionStr);


    RoleEntity findOne(RoleEntity role);

    /**
     * 查询所有
     * @return List<UserEntity>
     */
    List<RoleEntity> findAllList(RoleEntity role);

    /**
     * 查询所有
     * @param pageNumber    页码
     * @param pageSize      分页大小
     * @return  Page<UserEntity>
     */
    PageInfo<RoleEntity> findAllPageList(Integer pageNumber , Integer pageSize, RoleEntity role);

    /**
     * 保存
     * @param role
     */
    void save(RoleEntity role);
}
