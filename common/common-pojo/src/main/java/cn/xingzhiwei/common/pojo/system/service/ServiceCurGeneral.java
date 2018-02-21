package cn.xingzhiwei.common.pojo.system.service;

import cn.xingzhiwei.common.pojo.enumm.StateEnum;
import cn.xingzhiwei.common.pojo.mybatis.BaseMapper;
import cn.xingzhiwei.common.pojo.system.facade.IFacadeCurGeneral;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 通用service
 * Created by 韩峰 on 2018/2/21.
 */
@Service
public abstract class ServiceCurGeneral<T> implements IFacadeCurGeneral<T> {

    @Resource
    private BaseMapper<T> mapper;

    private Class<T> tClass;

    @Override
    public PageInfo<T> selectAllPage(Map<String, Object> map) throws RuntimeException {
        PageHelper.startPage(map);
        Example example = new Example(tClass);
        List<T> list= mapper.selectByExample(example);
        return new PageInfo<>(list);
    }

    private List<T> selectAllListByIds(String ids, StateEnum state) throws RuntimeException {
        Example example = new Example(tClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Arrays.asList(ids.split(",")));
        if (state != null) {
            criteria.andEqualTo("state",state.getState());
        }
        return mapper.selectByExample(example);
    }

    @Override
    public List<T> selectAllListByIds(String ids) throws RuntimeException {
        return selectAllListByIds(ids,null);
    }

    @Override
    public List<T> selectValidListByIds(String ids) throws RuntimeException {
        return selectAllListByIds(ids,StateEnum.NORMAL);
    }

    private List<T> selectAllListByIds(List<String> ids, StateEnum state) throws RuntimeException {
        Example example = new Example(tClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", ids);
        if (state != null) {
            criteria.andEqualTo("state",state.getState());
        }
        return mapper.selectByExample(example);
    }

    @Override
    public List<T> selectValidListByIds(List<String> ids) throws RuntimeException {
        return selectAllListByIds(ids,StateEnum.NORMAL);
    }

    @Override
    public List<T> selectAllListByIds(List<String> ids) throws RuntimeException {
        return selectAllListByIds(ids,null);
    }

    @Override
    public Map<String, T> selectAllMapByIds(String ids) throws RuntimeException {
        return null;
    }

    @Override
    public Map<String, T> selectValidMapByIds(List<String> ids) throws RuntimeException {
        return null;
    }

    @Override
    public int insert(T t) throws RuntimeException {
        return mapper.insertSelective(t);
    }

    @Override
    public int insert(List<T> tList) throws RuntimeException {
        return mapper.insertList(tList);
    }

    @Override
    public int updateById(T t) throws RuntimeException {
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(Object id) throws RuntimeException {
        return mapper.deleteByPrimaryKey(id);
    }
}
