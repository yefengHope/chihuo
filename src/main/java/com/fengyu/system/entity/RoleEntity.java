package com.fengyu.system.entity;

import java.lang.*;
import java.math.*;
import java.util.Date;

import com.fengyu.system.base.BaseEntity;
import com.fengyu.system.base.BaseModel;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 角色实体
 *
 * @author hanfeng
 * @date 2017-7-26 8:29:54
 */
@Entity
@Table(name = "ts_role")
public class RoleEntity extends BaseEntity {

    private static final long serialVersionUID = 3997327696037092185L;
    /**
     * 业务系统编号
     */
    private String systemId;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色唯一字符串
     */
    private String key;
    /**
     * 角色有效期
     */
    private Date validity;
    /**
     * 状态,1正常,0禁用,默认为1
     */
    private Integer state;
    /**
     * 排序序号,默认为1
     */
    private Integer sort;
    /**
     * 菜单访问权限
     */
    private String arights;
    /**
     * 菜单操作权限
     */
    private String hrights;
    /**
     * 创建人
     */
    private String aa01;
    /**
     * 创建时间
     */
    private Date aa02;
    /**
     * 修改人
     */
    private String ab01;
    /**
     * 修改时间
     */
    private Date ab02;

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

    /**
     * 获取角色名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * 设置角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    /**
     * 获取角色有效期
     */
    public Date getValidity() {
        return this.validity;
    }

    /**
     * 设置角色有效期
     */
    public void setValidity(Date validity) {
        this.validity = validity;
    }

    /**
     * 获取状态,1正常,0禁用,默认为1
     */
    public Integer getState() {
        return this.state;
    }

    /**
     * 设置状态,1正常,0禁用,默认为1
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取排序序号,默认为1
     */
    public Integer getSort() {
        return this.sort;
    }

    /**
     * 设置排序序号,默认为1
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取菜单访问权限
     */
    public String getArights() {
        return this.arights;
    }

    /**
     * 设置菜单访问权限
     */
    public void setArights(String arights) {
        this.arights = arights;
    }

    /**
     * 获取菜单操作权限
     */
    public String getHrights() {
        return this.hrights;
    }

    /**
     * 设置菜单操作权限
     */
    public void setHrights(String hrights) {
        this.hrights = hrights;
    }

    /**
     * 获取创建人
     */
    public String getAa01() {
        return this.aa01;
    }

    /**
     * 设置创建人
     */
    public void setAa01(String aa01) {
        this.aa01 = aa01;
    }

    /**
     * 获取创建时间
     */
    public Date getAa02() {
        return this.aa02;
    }

    /**
     * 设置创建时间
     */
    public void setAa02(Date aa02) {
        this.aa02 = aa02;
    }

    /**
     * 获取修改人
     */
    public String getAb01() {
        return this.ab01;
    }

    /**
     * 设置修改人
     */
    public void setAb01(String ab01) {
        this.ab01 = ab01;
    }

    /**
     * 获取修改时间
     */
    public Date getAb02() {
        return this.ab02;
    }

    /**
     * 设置修改时间
     */
    public void setAb02(Date ab02) {
        this.ab02 = ab02;
    }
}

