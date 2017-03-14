package com.fengyu.chihuo.domain.snacks;

import com.fengyu.system.base.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 小吃信息
 *      主表
 * Created by 韩峰 on 2016/8/2.
 */
@Entity
@Table(name = "t_ch_snacks")
public class Snacks extends BaseEntity {

    /**
     * 小吃店名
     */
    private String shop;

    /**
     * 招牌菜
     *  可能多个
     */
    /*@Transient
    private String specialty;*/


    /* ↓↓↓↓↓↓ 小吃所在地 ↓↓↓↓↓↓*/

    /**
     * 所属省
     */
    @Column(name = "province")
    private String province;

    /**
     * 所属市
     */
    @Column(name = "city")
    private String city;

    /**
     * 所属区/县
     * @return
     */
    @Column(name = "county")
    private String county;

    /**
     * 所属镇
     */
    @Column(name = "town")
    private String town;

    /**
     * 详细街道
     */
    @Column(name = "street_address")
    private String streetAddress;

    /* ↑↑↑↑↑↑ 小吃所在地 ↑↑↑*/

}
