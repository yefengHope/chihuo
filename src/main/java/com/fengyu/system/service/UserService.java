package com.fengyu.system.service;

import com.fengyu.system.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * @param pageable  分页
     * @return  Page<User>
     */
     Page<User> findAllPageList(Pageable pageable);

    /**
     * 保存
     * @param user
     */
    void save(User user);
}
