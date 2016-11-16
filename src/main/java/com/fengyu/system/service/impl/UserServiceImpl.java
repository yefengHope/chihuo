package com.fengyu.system.service.impl;

import com.fengyu.system.domain.User;
import com.fengyu.system.domain.repository.UserRepository;
import com.fengyu.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户类
 * Created by 韩峰 on 2016/8/10.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    /**
     * 查询所有用户 (此方法为异步)
     * @return {List}
     */
    @Async
    @Override
    public List<User> findAllList() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @Override
    public Page<User> findAllPageList(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
