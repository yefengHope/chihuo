package com.fengyu.chihuo.domain.snacks;

import com.fengyu.util.base.BaseEnity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 口味级
 * Created by 韩峰 on 2016/8/2.
 */
@Entity
@Table(name = "t_ch_taste")
public class Taste extends BaseEnity {

    private static final long serialVersionUID = 495225552200074477L;

    /**
     * 口味级
     */
    private Integer level;

    /**
     * 口味级说明
     */
    @Column(name = "level_des")
    private String levelDes;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelDes() {
        return levelDes;
    }

    public void setLevelDes(String levelDes) {
        this.levelDes = levelDes;
    }
}
