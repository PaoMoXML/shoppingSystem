package com.pojo;

public class Info {
    private Integer iId;

    private Integer iMoney;

    private Integer iStatus;

    private String iData;

    private Integer iUserid;

    public Integer getiId() {
        return iId;
    }

    public void setiId(Integer iId) {
        this.iId = iId;
    }

    public Integer getiMoney() {
        return iMoney;
    }

    public void setiMoney(Integer iMoney) {
        this.iMoney = iMoney;
    }

    public Integer getiStatus() {
        return iStatus;
    }

    public void setiStatus(Integer iStatus) {
        this.iStatus = iStatus;
    }

    public String getiData() {
        return iData;
    }

    public void setiData(String iData) {
        this.iData = iData == null ? null : iData.trim();
    }

    public Integer getiUserid() {
        return iUserid;
    }

    public void setiUserid(Integer iUserid) {
        this.iUserid = iUserid;
    }
}