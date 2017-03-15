package com.fengyu.system.service.impl;

import com.fengyu.system.dao.UserMapper;
import com.fengyu.system.entity.User;
import com.fengyu.system.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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

    /**
     * 查询所有
     *
     * @param page
     * @param pageSize
     * @return Page<User>
     */
    public PageInfo<User> findAllPageList(Integer page ,Integer pageSize) {
        if( page!= null && pageSize!= null){
            PageHelper.startPage(page, pageSize);
        }
        List<User> users = userMapper.findAllPage();
        return new PageInfo(users);
    }

    public void save(User user){
        // userRepository.save(user);
    }
}
