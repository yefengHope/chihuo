package com.fengyu.chihuo.domain.user;

import com.fengyu.util.base.BaseEnity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 用户口味
 *      -- 用于推送/首页匹配
 * Created by 韩峰 on 2016/8/2.
 */
@Entity
@Table(name = "t_ch_user_taste")
public class UserTaste extends BaseEnity{

    /*用户口味校验:
    *   通过比较知名的小吃,或者商场里面的热卖商品,来确定用户口味
    *   用户口味按级划分
    */

}
