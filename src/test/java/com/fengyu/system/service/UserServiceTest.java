package com.fengyu.system.service;

import com.fengyu.system.dao.UserMapper;
import com.fengyu.system.entity.UserEntity;
import com.fengyu.util.BaseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rain on 2017/8/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class UserServiceTest {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Test
    public void findOne() throws BaseException {
        UserEntity userEntity = new UserEntity();
        userEntity.setLoginNum("test00");
        List<UserEntity> list = userMapper.select(userEntity);
        UserEntity user1 = userMapper.selectOne(userEntity);
        UserEntity user2 = userService.findOne(userEntity);
        List<UserEntity> list1 = userService.findAllList(userEntity);
        System.out.println();
    }

}