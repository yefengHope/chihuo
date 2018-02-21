package cn.xingzhiwei.upms.service;

import cn.xingzhiwei.common.pojo.enumm.StateEnum;
import cn.xingzhiwei.upms.dao.ISystemUserMapper;
import cn.xingzhiwei.upms.entity.SystemUser;
import cn.xingzhiwei.upms.exception.UpmsException;
import cn.xingzhiwei.upms.facade.ISystemUserCurd;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 系统用户curd实现
 * Created by 韩峰 on 2018/2/19.
 */
@Service
public class SystemUserCurd implements ISystemUserCurd {

    @Resource
    private ISystemUserMapper systemUserMapper;

    @Override
    public PageInfo<SystemUser> selectAllPage(Map<String, Object> map) throws UpmsException {
        PageHelper.startPage(map);
        Example example = new Example(SystemUser.class);
        List<SystemUser> list= systemUserMapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    private List<SystemUser> selectAllListByIds(String ids, StateEnum state) throws UpmsException {
        Example example = new Example(SystemUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(ids.split(",")));
        if (state != null) {
            criteria.andEqualTo("state",state.getState());
        }
        return systemUserMapper.selectByExample(example);
    }

    @Override
    public List<SystemUser> selectAllListByIds(String ids) throws UpmsException {
        return selectAllListByIds(ids,null);
    }

    @Override
    public List<SystemUser> selectValidListByIds(String ids) throws UpmsException {
        return selectAllListByIds(ids,StateEnum.NORMAL);
    }

    private List<SystemUser> selectAllListByIds(List<String> ids, StateEnum state) throws UpmsException {
        Example example = new Example(SystemUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        if (state != null) {
            criteria.andEqualTo("state",state.getState());
        }
        return systemUserMapper.selectByExample(example);
    }

    @Override
    public List<SystemUser> selectValidListByIds(List<String> ids) throws UpmsException {
        return selectAllListByIds(ids,StateEnum.NORMAL);
    }

    @Override
    public List<SystemUser> selectAllListByIds(List<String> ids) throws RuntimeException {
        return selectAllListByIds(ids,null);
    }

    @Override
    public Map<String, SystemUser> selectAllMapByIds(String ids) throws UpmsException {
        return null;
    }

    @Override
    public Map<String, SystemUser> selectValidMapByIds(List<String> ids) throws UpmsException {
        return null;
    }

    @Override
    public int insert(SystemUser user) throws UpmsException {
        return 0;
    }

    @Override
    public int insert(List<SystemUser> users) throws UpmsException {
        return 0;
    }

    @Override
    public int updateById(SystemUser user) throws RuntimeException {
        return 0;
    }

    @Override
    public int delete(Object id) throws RuntimeException {
        return 0;
    }
}
