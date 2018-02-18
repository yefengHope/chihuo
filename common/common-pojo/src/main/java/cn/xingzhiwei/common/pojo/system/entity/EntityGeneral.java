package cn.xingzhiwei.common.pojo.system.entity;

import cn.xingzhiwei.common.pojo.validator.EntityInsert;
import cn.xingzhiwei.common.pojo.validator.EntityUpdate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Null;
import java.util.Date;

/**
 * 通用实体父类
 * Created by rain on 2018/2/18.
 */
public class EntityGeneral implements IEntityGeneral{
    private static final long serialVersionUID = -2915882725798606717L;
    /**
     * 版本号,md5加密整个字段
     */
    @Null(groups = {EntityInsert.class})
    @NotBlank(groups = {EntityUpdate.class})
    private String version;

    /**
     * 创建时间
     */
    @Null(groups = {EntityInsert.class})
    @NotBlank(groups = {EntityUpdate.class})
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @Null(groups = {EntityInsert.class})
    private Date gmtModified;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public Date getGmtModified() {
        return gmtModified;
    }

    @Override
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
