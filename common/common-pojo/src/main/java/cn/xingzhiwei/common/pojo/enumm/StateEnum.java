package cn.xingzhiwei.common.pojo.enumm;

/**
 * 状态枚举
 * Created by 韩峰 on 2018/2/18.
 */
public enum StateEnum {

    DELETE(0,"删除"),NORMAL(1,"正常"),LOCK(2,"锁定");

    private Integer state;

    private String remark;

    StateEnum(int state,String remark) {
        this.state = state;
        this.remark = remark;
    }

    public Integer getState() {
        return state;
    }

    public String getRemark() {
        return remark;
    }
}
