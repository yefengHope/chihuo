package com.fengyu.system.domain;

import com.fengyu.util.base.BaseEnity;

/**
 * 菜单类
 * Created by rain on 2016/11/7.
 */
public class Menu extends BaseEnity{

    /**
     * 父级id
     */
    private Long pid;
    /**
     * 菜单name
     */
    private String name;
    /**
     * 菜单url
     */
    private String url;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单排序号
     */
    private Integer sort;
    /**
     * 菜单级
     */
    private String level; //pid_id

    /**
     * 菜单上的页面权限
     */
    private String operate;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }
}
