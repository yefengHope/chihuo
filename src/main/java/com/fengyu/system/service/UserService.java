package com.fengyu.system.service;

import com.fengyu.system.entity.UserEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 韩峰 on 2016/8/10.
 */
public interface UserService {

    UserEntity findOne(UserEntity user);

    /**
     * 查询所有
     * @return List<UserEntity>
     */
    List<UserEntity> findAllList();

    /**
     * 查询所有
     * @param page
     * @param page
     * @return  Page<UserEntity>
     */
    PageInfo<UserEntity> findAllPageList(Integer page , Integer pageSize);

    /**
     * 保存
     * @param user
     */
    void save(UserEntity user);
}
