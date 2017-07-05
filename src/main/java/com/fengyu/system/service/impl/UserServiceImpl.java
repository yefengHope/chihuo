package com.fengyu.system.service.impl;

import com.fengyu.system.dao.UserMapper;
import com.fengyu.system.entity.User;
import com.fengyu.system.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.print.Pageable;
import java.util.List;

/**
 * 用户类
 * Created by 韩峰 on 2016/8/10.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;


    /**
     * 查询所有用户
     * @return {List}
     */
    public List<User> findAllList() {
        // List<User> users = (List<User>) userRepository.findAll();
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public Page<User> findAllPageList(Pageable pageable) {
        // return userRepository.findAll(pageable);
        return null;
    }



    /**
     * 查询所有
     *
     * @param page
     * @param pageSize
     * @return Page<User>
     */
    @Override
    public PageInfo<User> findAllPageList(Integer page, Integer pageSize) {
        // if( page!= null && pageSize!= null){
        //     PageHelper.startPage(page, pageSize);
        // }
        // List<User> users = userMapper.findAllPage();
        // return new PageInfo(users);

        return null;
    }

    public void save(User user){
        // userRepository.save(user);
    }
}
