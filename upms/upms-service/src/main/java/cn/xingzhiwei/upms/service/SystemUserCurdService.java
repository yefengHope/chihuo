package cn.xingzhiwei.upms.service;

import cn.xingzhiwei.common.pojo.system.service.AbstractServiceCurGeneral;
import cn.xingzhiwei.upms.dao.ISystemUserMapper;
import cn.xingzhiwei.upms.entity.SystemUser;
import cn.xingzhiwei.upms.facade.ISystemUserCurd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 系统用户curd实现
 * Created by 韩峰 on 2018/2/19.
 */
@Service
public class SystemUserCurdService extends AbstractServiceCurGeneral<SystemUser> implements ISystemUserCurd {

    @Resource
    private ISystemUserMapper systemUserMapper;

}
