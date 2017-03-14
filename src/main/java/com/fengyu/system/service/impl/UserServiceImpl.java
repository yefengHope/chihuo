package com.fengyu.system.service.impl;

import com.fengyu.system.dao.UserMapper;
import com.fengyu.system.entity.User;
import com.fengyu.system.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户类
 * Created by 韩峰 on 2016/8/10.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;


    /**
     * 查询所有用户
     * @return {List}
     */
    public List<User> findAllList() {
        // List<User> users = (List<User>) userRepository.findAll();
        List<User> users = userMapper.findAllPage();
        return users;
    }

    // @Override
    // public Page<User> findAllPageList(Pageable pageable) {
    //     // return userRepository.findAll(pageable);
    //     return null;
    // }

    public void save(User user){
        // userRepository.save(user);
    }
}
