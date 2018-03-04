package cn.xingzhiwei.upms.facade;

import cn.xingzhiwei.common.pojo.system.facade.IFacadeCurGeneral;
import cn.xingzhiwei.upms.exception.UpmsException;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by HF on 2018/3/4.
 */
public interface IFacadeCurUpms<T> extends IFacadeCurGeneral<T> {

    /**
     * 分页查询
     * @param map 查询参数
     * @return PageInfo<T>
     */
    PageInfo<T> selectAllPage(Map<String,Object> map) throws UpmsException;

    /**
     * 根据ids查询所有
     * @param ids 1,2,3,...
     * @return {@code List<T>}
     */
    List<T> selectAllListByIds(String ids) throws UpmsException;

    /**
     * 根据ids查询有效
     * @param ids 1,2,3,...
     * @return {@code List<T>}
     */
    List<T> selectValidListByIds(String ids) throws UpmsException;

    /**
     * 根据ids查询有效
     * @param ids [1,2,3,...]
     * @return {@code List<T>}
     */
    List<T> selectValidListByIds(List<String> ids) throws UpmsException;

    /**
     * 根据ids查询有效
     * @param ids [1,2,3,...]
     * @return {@code List<T>}
     */
    List<T> selectAllListByIds(List<String> ids) throws UpmsException;

    /**
     * 根据ids查询所有
     * @param ids 1,2,3,...
     * @return {@code Map<String ,T>}
     */
    Map<String ,T> selectAllMapByIds(String ids) throws UpmsException;
    /**
     * 根据ids查询有效
     * @param ids [1,2,3,...]
     * @return {@code Map<String ,T>}
     */
    Map<String ,T> selectValidMapByIds(List<String> ids) throws UpmsException;

    /**
     * 插入
     * @param user {@link T}
     * @return {@link T}
     */
    int insert(T user) throws UpmsException;

    /**
     * 插入 - 批量,该接口限制实体包含id属性并且必须为自增列
     * @param users {@link T}
     * @return {@link T}
     */
    int insert(List<T> users) throws UpmsException;

    /**
     * 修改
     * @param user {@link T}
     * @return {@link T}
     */
    int updateById(T user) throws UpmsException;

    /**
     * 删除
     * @param id {@link T}的id
     * @return {@link T}
     */
    int delete(Object id) throws UpmsException;
}
