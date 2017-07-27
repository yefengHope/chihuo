package com.fengyu.system.service.impl;

import com.fengyu.system.dao.RoleMapper;
import com.fengyu.system.dao.UserAndRoleMapper;
import com.fengyu.system.entity.RoleEntity;
import com.fengyu.system.entity.UserAndRoleEntity;
import com.fengyu.system.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private static Logger logger;
    static {
        logger = LoggerFactory.getLogger(RoleServiceImpl.class);
    }

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private UserAndRoleMapper userAndRoleMapper;

    @Override
    public List<RoleEntity> getRoles(String userId) {
        UserAndRoleEntity userAndRole = new UserAndRoleEntity();
        userAndRole.setUserId(userId);
        List<UserAndRoleEntity> userAndRoleEntityList = userAndRoleMapper.select(userAndRole);
        if (userAndRoleEntityList.size() <= 0) {
            logger.error("数据表UserAndRoleEntity为空，无对应数据");
            return null;
        }
        Set<Long> roleSet = new HashSet<>();
        userAndRoleEntityList.forEach( n -> { roleSet.add(n.getRoleId()); } );
        return roleMapper.findByRoleList(new ArrayList<>(roleSet));
    }

    @Override
    public boolean authorized(String loginId, String domainStr, String permissionStr) {
        return false;
    }
}
