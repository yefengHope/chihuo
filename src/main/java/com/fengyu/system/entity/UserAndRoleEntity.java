package com.fengyu.system.entity;

import com.fengyu.system.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * 角色实体
 *
 * @author hanfeng
 * @date 2017-7-26 8:57:14
 */
@Entity
@Table(name ="ts_user_role")
public class UserAndRoleEntity extends BaseEntity {


    private static final long serialVersionUID = 3663056250043943633L;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 业务系统编号
     */
    private String systemId;

    /**
     * 角色编号
     */
    private Long roleId;

    /**
     * 获取用户编号
     */
    public String getUserId() {
        return this.userId;
    }

    /**
     * 设置用户编号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取业务系统编号
     */
    public String getSystemId() {
        return this.systemId;
    }

    /**
     * 设置业务系统编号
     */
    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}

