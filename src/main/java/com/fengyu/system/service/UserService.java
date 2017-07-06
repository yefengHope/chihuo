package com.fengyu.system.service;

import com.fengyu.system.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 韩峰 on 2016/8/10.
 */
public interface UserService {

    /**
     * 查询所有
     * @return List<User>
     */
    List<User> findAllList();

    /**
     * 查询所有
     * @param page
     * @param page
     * @return  Page<User>
     */
    PageInfo<User> findAllPageList(Integer page , Integer pageSize);

    /**
     * 保存
     * @param user
     */
    void save(User user);
}
