package cn.xingzhiwei.common.pojo.system.entity;

import java.io.Serializable;

/**
 * 实体UUID接口约束
 * Created by rain on 2018/2/18.
 */
public interface IEntityUuid<T> extends Serializable {

    String getId();

    void setId(String id);

    T buildEntityAndUUID();

    T buildEntityAndUUID(T t);

}
