package com.fengyu.util;

import com.fengyu.system.domain.User;
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
    public static User getUserSession(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        User user = (User) request.getSession().getAttribute(CommonKey.USER_SESSION);
        return user;
    }
}
