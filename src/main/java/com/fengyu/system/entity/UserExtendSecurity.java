package com.fengyu.system.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by HanFeng on 2017/7/28.
 */
public class UserExtendSecurity extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = -5458107170396472077L;

    private String loginName;

    private String loginNum;

    public UserExtendSecurity(String username, String password, Collection<? extends GrantedAuthority> authorities, String loginName, String loginNum) {
        super(username, password, authorities);
        this.loginName = loginName;
        this.loginNum = loginNum;
    }

    public UserExtendSecurity(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, String loginName, String loginNum) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.loginName = loginName;
        this.loginNum = loginNum;
    }

    // 父类构造方法
    private UserExtendSecurity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    // 父类构造方法
    private UserExtendSecurity(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum;
    }
}
