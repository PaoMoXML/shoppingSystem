package com.pojo;

public class Focus {
    private Integer fId;

    private String fFocustime;

    private Integer fUserid;

    private Integer fGoods;

    private Integer fStatus;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfFocustime() {
        return fFocustime;
    }

    public void setfFocustime(String fFocustime) {
        this.fFocustime = fFocustime == null ? null : fFocustime.trim();
    }

    public Integer getfUserid() {
        return fUserid;
    }

    public void setfUserid(Integer fUserid) {
        this.fUserid = fUserid;
    }

    public Integer getfGoods() {
        return fGoods;
    }

    public void setfGoods(Integer fGoods) {
        this.fGoods = fGoods;
    }

    public Integer getfStatus() {
        return fStatus;
    }

    public void setfStatus(Integer fStatus) {
        this.fStatus = fStatus;
    }
}