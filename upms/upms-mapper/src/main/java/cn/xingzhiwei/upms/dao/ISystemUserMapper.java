package cn.xingzhiwei.upms.dao;

import cn.xingzhiwei.common.pojo.mybatis.BaseMapper;
import cn.xingzhiwei.upms.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户mapper
 * Created by 韩峰 on 2018/2/19.
 */
@Mapper
public interface ISystemUserMapper extends BaseMapper<SystemUser> {
}
