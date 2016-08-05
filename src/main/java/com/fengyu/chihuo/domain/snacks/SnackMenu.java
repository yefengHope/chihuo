package com.fengyu.chihuo.domain.snacks;

import com.fengyu.util.domain.BaseEnity;

import javax.persistence.*;

/**
 * 菜单信息
 *  --  小吃店所包含的特色菜单信息
 * Created by 韩峰 on 2016/8/2.
 */
@Entity
@Table(name = "t_ch_snack_menu")
public class SnackMenu extends BaseEnity{


    private static final long serialVersionUID = 8268802064066987460L;

    @ManyToOne
    @JoinColumn(name = "snacksnacks_id")
    private Snacks snacksnacksId;

    /**
     * 特色菜名
     */
    private String specialty;

    /**
     * 特色菜价格
     */
    private Double price;

    /**
     * 特色菜照片
     */
    private String img;

    /**
     * 特色菜口味
     */
    private String taste;
}
