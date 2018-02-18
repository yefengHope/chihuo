package cn.xingzhiwei.common.pojo.system.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体通用约束
 *
 * Created by rain on 2018/2/18.
 */
public interface IEntityGeneral extends Serializable {

    /**
     * 获取版本号
     */
    String getVersion();

    /**
     * 设置版本号
     * @param version
     * @return
     */
    void setVersion(String version);

    /**
     * 获取创建时间
     */
    Date getGmtCreate();

    /**
     * 设置创建时间
     * @param date date
     */
    void setGmtCreate(Date date);

    /**
     * 获取修改时间
     */
    Date getGmtModified();

    /**
     * 设置修改时间
     * @param date date
     */
    void setGmtModified(Date date);

}
