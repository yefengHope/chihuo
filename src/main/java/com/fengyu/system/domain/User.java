package com.fengyu.system.domain;

import com.fengyu.util.base.BaseEnity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 用户
 * Created by 韩峰 on 2016/8/2.
 */
@Entity
@Table(name = "ts_user")
public class User extends BaseEnity{

    private static final long serialVersionUID = -4886379701339312835L;

    /*  登录说明:
            可用账号,手机号和邮箱登录
        安全:
            安全问题;
    */

    /**
     * 用户昵称
     */
    @NotBlank
    @Column(name = "name")
    private String name;

    /**
     * 登录账号
     */
    @NotBlank
    @Column(name = "login_num",nullable = false,unique = true)
    private String loginNum;

    /**
     * 登录密码
     */
    @NotEmpty
    @Column(name = "login_pwd")
    private String loginPwd;

    /**
     * 账号状态
     */
    @Column(name = "a_status")
    private Integer aStatus;

    /**
     * 用户手机号
     */
    @NotNull
    private Long phone;
    /**
     * 用户邮箱
     */
    @Email
    private String email;

    /**
     * 用户头像
     */
    @Column(name = "head_icon")
    private String headIcon;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getLoginNum() {
        return loginNum;
    }

    public void setLoginNum(String loginNum) {
        this.loginNum = loginNum;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Integer getaStatus() {
        return aStatus;
    }

    public void setaStatus(Integer aStatus) {
        this.aStatus = aStatus;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
