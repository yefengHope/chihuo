package com.fengyu.system.service.impl;

import com.fengyu.system.entity.SystemMenuEntity;
import com.fengyu.system.entity.UserExtendSecurity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * Created by HanFeng on 2017/7/28.
 */
public class UserDetailsExtendImpl extends UserExtendSecurity {

    private static final long serialVersionUID = -579785664428887347L;

    public UserDetailsExtendImpl(String username, String password, Collection<? extends GrantedAuthority> authorities, String userId, String userName, String loginNum, List<SystemMenuEntity> menuList, List<String> roleAccessUrlList) {
        super(username, password, authorities, userId, userName, loginNum, menuList, roleAccessUrlList);
    }

    public UserDetailsExtendImpl(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String userId, String userName, String loginNum, List<SystemMenuEntity> menuList, List<String> roleAccessUrlList) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, userId, userName, loginNum, menuList, roleAccessUrlList);
    }
}
