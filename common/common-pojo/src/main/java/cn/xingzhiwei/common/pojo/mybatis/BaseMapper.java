package cn.xingzhiwei.common.pojo.mybatis;

import tk.mybatis.mapper.common.Mapper;

/**
 * 1.Mapper<T>
 *     继承了BaseMapper<T>, ExampleMapper<T>, RowBoundsMapper<T>三个组合接口
 * 2.IdsMapper<T>
 *     通过操作ids字符串进行操作，ids 如 "1,2,3" 这种形式的字符串，这个方法要求实体类中有且只有一个带有@Id注解的字段，否则会抛出异常。
 * 3.MySqlMapper<T>
 *     MySQL专用
 *     InsertListMapper 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含id属性并且必须为自增列
 *     InsertUseGeneratedKeysMapper 插入数据，限制为实体包含id属性并且必须为自增列，实体配置的主键策略无效
 * Created by rain on 2018/2/15.
 */
public interface BaseMapper<T> extends Mapper<T> {
}
