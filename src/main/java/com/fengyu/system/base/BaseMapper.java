package com.fengyu.system.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by rain on 2017/3/14.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T>  {

    //TODO 特别注意，该接口不能被扫描到，否则会出错


}
