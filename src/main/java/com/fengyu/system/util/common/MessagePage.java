package com.fengyu.system.util.common;

/**
 * 提示信息
 * <p>说明:返回页面的消息提示</p>
 * Created by rain on 2016/11/5.
 */
public class MessagePage {

    /**
     * 返回的默认状态
     */
    public final static Integer ERROR = 0;      //错误
    public final static Integer SUCCESS = 1;    //成功
    public final static Integer GOTO = 2;       //跳转

    /**
     * 返回状态
     */
    public Integer status;

    /**
     * 返回提示内容
     */
    public String info;

    /**
     * 返回数据
     */
    public String data;

    /**
     * 返回url
     */
    public String url;

    /**
     * 返回页面提示
     * @param status    返回状态  (ERROR = 0; //错误  ,SUCCESS = 1; //成功  , GOTO = 2;  //跳转)
     * @param info      返回提示内容
     * @param data      返回数据
     * @param url       返回url
     */
    public MessagePage(Integer status, String info, String data, String url) {
        this.status = status;
        this.info = info;
        this.data = data;
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    /**
     * 有三个默认状态,请勿占用
     * <p>
     *      public final static Integer ERROR = 0;      //错误
     *      public final static Integer SUCCESS = 1;    //成功
     *      public final static Integer GOTO = 2;       //跳转
     * </p>
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
