<#--FreeMarker  测试模板 生成成功-->
package com.media.dao;

import java.util.List;

import com.media.bean.${model_name};
import com.media.exceptions.DAOException;

/**
* ${model_name_cn}接口
*
* @author ${author}
* @link ${link}
*
* @version $Revision: 1.00 $ $Date: ${date?string("yyyy-MM-dd HH:mm:ss")}
*/
public interface I${model_name}DAO extends IGenericDAO<${model_name}>{

/**
* 根据${model_name_cn}编号查找${model_name_cn}信息
*
* @param ${instant}Id ${model_name_cn}编号
* @return ${model_name} ${model_name_cn}对象
* @throws DAOException
*/
public ${model_name} find${model_name}ById(Long ${instant}Id) throws DAOException;

/**
* 批量物理删除${model_name_cn}(不可恢复)
* @param ${instant}Ids  ${model_name_cn}编号
* @throws DAOException
*/
public void delete${model_name_list}(Long[] ${instant}Ids) throws DAOException;

/**
* 物理删除${model_name_cn}(不可恢复)
* @param ${instant}Id  ${model_name_cn}编号
* @throws DAOException
*/
public void delete${model_name}(Long ${instant}Id) throws DAOException;

/**
* 保存${model_name_cn}
* @param ${instant}
* @throws DAOException
*/
public void save${model_name}(${model_name} ${instant}) throws DAOException;

/**
* 更新${model_name_cn}
* @param ${instant}
* @throws DAOException
*/
public void update${model_name}(${model_name} ${instant}) throws DAOException;

/**
* 利用hql语句查询${model_name_cn}信息
* @param hsql
* @throws DAOException
*/
public List<${model_name}> find${model_name_list}(String hsql) throws DAOException;

/**
* 利用hql语句查询${model_name_cn}信息
* @param hsql
* @throws DAOException
*/
public List<${model_name}> find${model_name_list}(String hsql,Object[] params) throws DAOException;

} 