package com.fengyu.system.service.impl;

import com.fengyu.system.entity.Role;
import com.fengyu.system.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/7/3 16:37 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> getRoles(Long userId) {
        return null;
    }

    @Override
    public boolean authorized(Long loginId, String domainStr, String permissionStr) {
        return false;
    }
}
