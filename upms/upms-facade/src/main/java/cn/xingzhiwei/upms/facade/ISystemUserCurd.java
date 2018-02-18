package cn.xingzhiwei.upms.facade;

import cn.xingzhiwei.common.pojo.facade.IFacadeCurGeneral;
import cn.xingzhiwei.upms.entity.SystemUser;
import cn.xingzhiwei.upms.exception.UpmsException;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 系统用户接口 - 增删改查
 * Created by 韩峰 on 2018/2/18.
 */
public interface ISystemUserCurd extends IFacadeCurGeneral<SystemUser> {

    /**
     * 分页查询
     * @param map 查询参数
     * @return PageInfo<SystemUser>
     */
    PageInfo<SystemUser> selectAllPage(Map<String,Object> map) throws UpmsException;

    /**
     * 根据ids查询所有
     * @param ids 1,2,3,...
     * @return {@code List<SystemUser>}
     */
    List<SystemUser> selectAllListByIds(String ids) throws UpmsException;

    /**
     * 根据ids查询有效
     * @param ids 1,2,3,...
     * @return {@code List<SystemUser>}
     */
    List<SystemUser> selectValidListByIds(String ids) throws UpmsException;

    /**
     * 根据ids查询有效
     * @param ids [1,2,3,...]
     * @return {@code List<SystemUser>}
     */
    List<SystemUser> selectValidListByIds(List<String> ids) throws UpmsException;

    /**
     * 根据ids查询所有
     * @param ids 1,2,3,...
     * @return {@code Map<String ,SystemUser>}
     */
    Map<String ,SystemUser> selectAllMapByIds(String ids) throws UpmsException;
    /**
     * 根据ids查询有效
     * @param ids [1,2,3,...]
     * @return {@code Map<String ,SystemUser>}
     */
    Map<String ,SystemUser> selectValidMapByIds(List<String> ids) throws UpmsException;

    /**
     * 插入
     * @param user {@link SystemUser}
     * @return {@link SystemUser}
     */
    int insert(SystemUser user) throws UpmsException;

    /**
     * 插入 - 批量
     * @param users {@link SystemUser}
     * @return {@link SystemUser}
     */
    int insert(List<SystemUser> users) throws UpmsException;

    /**
     * 修改
     * @param user {@link SystemUser}
     * @return {@link SystemUser}
     */
    int update(SystemUser user) throws UpmsException;

    /**
     * 删除
     * @param id {@link SystemUser}的id
     * @return {@link SystemUser}
     */
    int delete(String id) throws UpmsException;

}
