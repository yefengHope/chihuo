package com.fengyu.util.common;

import com.fengyu.system.entity.UserEntity;
import com.fengyu.system.entity.UserExtendSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
     * @deprecated
     */
    public static UserEntity getUserSession(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UserEntity user = (UserEntity) request.getSession().getAttribute(CommonKey.USER_SESSION);
        return user;
    }

    /**
     * 获取spring security登录缓存中用户对象
     * @return {UserExtendSecurity}
     */
    public static UserExtendSecurity getUserSeesionBySecurity() {
        UserExtendSecurity userDetails = (UserExtendSecurity) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userDetails;
    }

    /**
     * 获取spring security登录缓存中用户对象
     * @return {UserExtendSecurity}
     */
    public static Authentication getAuthenticationBySecurity() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return authentication;
    }
}
