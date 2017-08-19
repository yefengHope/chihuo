package com.fengyu.system.service.impl;

import com.fengyu.system.base.BaseEntity;
import com.fengyu.system.entity.UserAndRoleEntity;
import com.fengyu.system.service.UserAndRoleExtendService;
import com.fengyu.system.service.UserAndRoleService;
import com.fengyu.util.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by rain on 2017/8/9.
 */
@Service
public class UserAndRoleExtendServiceImpl implements UserAndRoleExtendService {

    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(UserAndRoleExtendServiceImpl.class);
    }
    @Resource
    private UserAndRoleService userAndRoleService;

    /**
     * 批量关联用户和角色
     *
     * @param userIds 用户id数组
     * @param roleIds 角色id数组
     */
    @Override
    @Transactional
    public void batchRelateUserAndRole(String[] userIds, String[] roleIds) throws BaseException {
        if (null != userIds && null != roleIds
                && userIds.length > 0 && roleIds.length > 0) {
            for (String userId : userIds) {
                for (String roleId : roleIds) {
                    UserAndRoleEntity userAndRoleEntity = new UserAndRoleEntity();
                    userAndRoleEntity.setRoleId(Long.parseLong(roleId));
                    userAndRoleEntity.setUserId(userId);
                    // 查询数据库
                    UserAndRoleEntity userAndRoleDb = userAndRoleService.findOne(userAndRoleEntity);
                    if ( null != userAndRoleDb && 1 == userAndRoleDb.getStatus()) {
                        // 状态正常 ，掠过
                        continue;
                    }
                    userAndRoleEntity.setStatus(1); // 设置状态

                    if (null != userAndRoleDb && null != userAndRoleDb.getId() ) {
                        // 如果当前数据库中存在此数据
                        BaseEntity.setUpdateUser(userAndRoleEntity);
                        userAndRoleService.update(userAndRoleEntity);
                    } else {
                        // 如果当前数据库中无
                        BaseEntity.setCreateAndUpdateUser(userAndRoleEntity);
                        userAndRoleService.save(userAndRoleEntity);
                    }
                }
            }
        } else {
            throw new NullPointerException("【批量关联用户和角色】，无userIds或roleIds");
        }
    }
}
