package com.fengyu.system.service;

import com.fengyu.system.base.BaseService;
import com.fengyu.system.entity.SystemMenuEntity;

import java.util.List;

/**
* 自动生成代码
* Created by HF on 2017-8-8 22:26:54.
*/
public interface SystemMenuService extends BaseService<SystemMenuEntity>{

    List<SystemMenuEntity> selectByIds(String ids);
}