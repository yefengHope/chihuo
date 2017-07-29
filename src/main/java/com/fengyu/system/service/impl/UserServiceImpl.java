package com.fengyu.system.service.impl;

import com.fengyu.system.dao.UserMapper;
import com.fengyu.system.entity.UserEntity;
import com.fengyu.system.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户类
 * Created by 韩峰 on 2016/8/10.
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    private static Logger logger;
    static {
        logger = LoggerFactory.getLogger(UserServiceImpl.class);
    }

    @Resource
    private UserMapper userMapper;

    public UserEntity findOne(UserEntity user){
        return userMapper.selectOne(user);
    }

    /**
     * 查询所有用户
     * @return {List}
     */
    public List<UserEntity> findAllList() {
        List<UserEntity> users = userMapper.selectAll();
        return users;
    }


    @Override
    public PageInfo<UserEntity> findAllPageList(Integer pageNumber, Integer pageSize) {
        if( pageNumber!= null && pageSize!= null){
            PageHelper.startPage(pageNumber, pageSize);
        }
        List<UserEntity> users = userMapper.selectAll();
        return new PageInfo<>(users);
    }

    public void save(UserEntity user){
        if (user != null) {
            if (StringUtils.isNotBlank(user.getId())) {
                userMapper.insert(user);
            } else {
                userMapper.updateByPrimaryKey(user);
            }
        } else {
            logger.error("保存或更新数据，但是数据不存在");
        }
    }
}
