package com.fengyu.system.service.impl;

import com.fengyu.system.entity.UserExtendSecurity;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by HanFeng on 2017/7/28.
 */
public class UserDetailsExtendImpl extends UserExtendSecurity {

    private static final long serialVersionUID = 937752386767248410L;

    public UserDetailsExtendImpl(String username, String password, Collection<? extends GrantedAuthority> authorities, String loginName, String loginNum) {
        super(username, password, authorities, loginName, loginNum);
    }

    public UserDetailsExtendImpl(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String loginName, String loginNum) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, loginName, loginNum);
    }
}
