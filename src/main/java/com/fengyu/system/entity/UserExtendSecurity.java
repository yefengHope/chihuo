package com.fengyu.system.entity;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by HanFeng on 2017/7/28.
 */
public class UserExtendSecurity extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = -5458107170396472077L;

    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户帐号
     */
    private String loginNum;

    public UserExtendSecurity(String username, String password, Collection<? extends GrantedAuthority> authorities,
                              String userId, String userName, String loginNum) {
        super(username, password, authorities);
        this.userId = userId;
        this.userName = userName;
        this.loginNum = loginNum;
    }

    public UserExtendSecurity(String username, String password, boolean enabled, boolean accountNonExpired
            , boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities
            , String userId, String userName, String loginNum) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
        this.userName = userName;
        this.loginNum = loginNum;
    }

    public UserExtendSecurity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserExtendSecurity(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }


    /**
     * 用户id
     */
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 用户昵称
     */
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 用户帐号
     */
    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum;
    }
}
