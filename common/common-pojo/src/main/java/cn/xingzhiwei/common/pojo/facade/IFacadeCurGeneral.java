package cn.xingzhiwei.common.pojo.facade;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 通用facade curd 接口
 * Created by Administrator on 2018/2/18.
 */
public interface IFacadeCurGeneral<T> {

    /**
     * 分页查询
     * @param map 查询参数
     * @return PageInfo<T>
     */
    PageInfo<T> selectAllPage(Map<String,Object> map) throws RuntimeException;

    /**
     * 根据ids查询所有
     * @param ids 1,2,3,...
     * @return {@code List<T>}
     */
    List<T> selectAllListByIds(String ids) throws RuntimeException;

    /**
     * 根据ids查询有效
     * @param ids 1,2,3,...
     * @return {@code List<T>}
     */
    List<T> selectValidListByIds(String ids) throws RuntimeException;

    /**
     * 根据ids查询有效
     * @param ids [1,2,3,...]
     * @return {@code List<T>}
     */
    List<T> selectValidListByIds(List<String> ids) throws RuntimeException;

    /**
     * 根据ids查询所有
     * @param ids 1,2,3,...
     * @return {@code Map<String ,T>}
     */
    Map<String ,T> selectAllMapByIds(String ids) throws RuntimeException;
    /**
     * 根据ids查询有效
     * @param ids [1,2,3,...]
     * @return {@code Map<String ,T>}
     */
    Map<String ,T> selectValidMapByIds(List<String> ids) throws RuntimeException;

    /**
     * 插入
     * @param user {@link T}
     * @return {@link T}
     */
    int insert(T user) throws RuntimeException;

    /**
     * 插入 - 批量
     * @param users {@link T}
     * @return {@link T}
     */
    int insert(List<T> users) throws RuntimeException;

    /**
     * 修改
     * @param user {@link T}
     * @return {@link T}
     */
    int update(T user) throws RuntimeException;

    /**
     * 删除
     * @param id {@link T}的id
     * @return {@link T}
     */
    int delete(String id) throws RuntimeException;
}
