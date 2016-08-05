package com.fengyu.util.domain;

import com.fengyu.system.domain.User;
import com.fengyu.util.CommonUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 基本实体
 * Created by 韩峰 on 2016/8/2.
 */
@MappedSuperclass
public class BaseEnity implements Serializable {


    private static final long serialVersionUID = 887436082747947410L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 创建人id
     */
    @Column(name = "create_id")
    private Long createId;
    /**
     * 创建人name
     */
    @Column(name = "create_name")
    private String createName;
    /**
     * 创建人date
     */
    @Column(name = "create_date")
    private Date createDate;
    /**
     * 更新人id
     */
    @Column(name = "update_id")
    private Long updateId;
    /**
     * 更新人name
     */
    @Column(name = "update_name")
    private String updateName;
    /**
     * 更新date
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 状态
     *  0 = 删除, 1= 正常
     *  默认 : 1;
     */
    private Integer status = 1;

    /**
     * 执行插入数据之后回调
     *  更新创建人人id,name和时间
     */
    @PostPersist
    public void setCreateUser(){
        User user = CommonUtils.getUserSession();
        this.createId = user.getId();
        this.createName = user.getName();
        this.createDate = new Date();
    }

    /**
     * 执行更新之后回调
     *  更新最后修改人id,name和时间
     */
    @PostUpdate
    public void seUpdateUser(){
        User user = CommonUtils.getUserSession();
        this.updateId = user.getId();
        this.updateName = user.getName();
        this.updateDate = new Date();
    }

    public void createDate(){
        this.createDate = new Date();
    }

    public void updateDate(){
        this.updateDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
