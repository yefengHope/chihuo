package com.fengyu.system.security;

import com.fengyu.system.entity.LoginEntity;
import com.fengyu.system.service.LoginService;
import com.fengyu.system.service.RoleService;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>@Title spring security 实现自定义验证 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/7/3 15:43 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
@Component
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Resource(name = "loginService")
    private LoginService loginService;

    @Resource(name = "roleService")
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("用户名为空");
        }

        LoginEntity login = loginService.findByUsername(username);
        if (login == null) {
            throw new UsernameNotFoundException("not found");
        }

        Set<GrantedAuthority> authorities = new HashSet<>();
        roleService.getRoles(login.getId())
                .forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getKey()))
                );
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(
                username, login.getPassword(),
                true,               //是否可用
                true,       //是否过期
                true,   //证书不过期为true
                true,       //账户未锁定为true
                authorities);

        return user;
    }
}
