package com.fengyu.util.customData.area_json.java;

import java.util.Date;
import java.util.List;

/**
 * 地区实体
 * Created by rain on 2016/8/16.
 */
public class Area {

    private Long tid;
    private Long tpid;
    private String tname;
    private String ttext;
    private Long ttype;
    private Long tpx;
    private Long tuser;
    private Long tdept;
    private Date tdate;
    private String turl;
    private String tlvie;
    private List<Area> childs;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getTpid() {
        return tpid;
    }

    public void setTpid(Long tpid) {
        this.tpid = tpid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTtext() {
        return ttext;
    }

    public void setTtext(String ttext) {
        this.ttext = ttext;
    }

    public Long getTtype() {
        return ttype;
    }

    public void setTtype(Long ttype) {
        this.ttype = ttype;
    }

    public Long getTpx() {
        return tpx;
    }

    public void setTpx(Long tpx) {
        this.tpx = tpx;
    }

    public Long getTuser() {
        return tuser;
    }

    public void setTuser(Long tuser) {
        this.tuser = tuser;
    }

    public Long getTdept() {
        return tdept;
    }

    public void setTdept(Long tdept) {
        this.tdept = tdept;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }

    public String getTlvie() {
        return tlvie;
    }

    public void setTlvie(String tlvie) {
        this.tlvie = tlvie;
    }

    public List<Area> getChilds() {
        return childs;
    }

    public void setChilds(List<Area> childs) {
        this.childs = childs;
    }
}
