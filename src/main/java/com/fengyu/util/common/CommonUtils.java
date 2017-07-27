package com.fengyu.util.common;

import com.fengyu.system.entity.UserEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取公共类
 * Created by 韩峰 on 2016/8/2.
 */
public class CommonUtils {

    /**
     * 获取用户session
     * @return
     */
    public static UserEntity getUserSession(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserEntity user = (UserEntity) request.getSession().getAttribute(CommonKey.USER_SESSION);
        return user;
    }
}
