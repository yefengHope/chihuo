package com.fengyu.system.service.impl;

import com.fengyu.system.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by 韩峰 on 2016/8/10.
 */
@Service
public class UserServiceImpl implements UserService{

    /*@Autowired
    private UserRepository userRepository;*/

    public boolean test(){
        String string = new String("123123123213");
//       return userRepository.support(string);
        return false;
    }
}
