package cn.xingzhiwei.upms.entity;

import cn.xingzhiwei.common.pojo.enumm.StateEnum;
import cn.xingzhiwei.common.pojo.system.entity.EntityGeneral;
import cn.xingzhiwei.common.pojo.system.entity.IEntityUuid;
import cn.xingzhiwei.common.pojo.validator.EntityUpdate;
import cn.xingzhiwei.common.utils.UUIDUtils;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 系统用户
 * Created by rain on 2018/2/18.
 */
@Entity
@Table(name = "t_sys_user")
public class SystemUser extends EntityGeneral implements IEntityUuid<SystemUser> {

    private static final long serialVersionUID = -3246570641856197850L;
    @Id
    @NotBlank(groups = {EntityUpdate.class})
    private String id;

    @NotBlank(groups = {EntityUpdate.class})
    @Size(min = 6,max = 20)
    @Column(name= "user_name")
    private String userName;

    @NotBlank(groups = {EntityUpdate.class})
    @Size(min = 6,max = 20)
    @Column(name= "user_pwd")
    private String userPwd;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phone;

    /**
     * 状态
     * @see StateEnum 0：删除 1：正常 2：锁定
     */
    @NotBlank
    private Integer state;

    @Override
    public SystemUser buildEntityAndUUID() {
        SystemUser user = new SystemUser();
        user.setId(UUIDUtils.getUUID());
        return user;
    }

    @Override
    public SystemUser buildEntityAndUUID(SystemUser systemUser) {
        systemUser.setId(UUIDUtils.getUUID());
        return systemUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
