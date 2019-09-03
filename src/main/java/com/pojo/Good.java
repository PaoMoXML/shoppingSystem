package com.pojo;

public class Good {
    private Integer gId;

    private String gName;

    private Integer gPrecost;

    private Integer gCost;

    private Integer gQuantity;

    private String gMsg;

    private Integer gType;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    public Integer getgPrecost() {
        return gPrecost;
    }

    public void setgPrecost(Integer gPrecost) {
        this.gPrecost = gPrecost;
    }

    public Integer getgCost() {
        return gCost;
    }

    public void setgCost(Integer gCost) {
        this.gCost = gCost;
    }

    public Integer getgQuantity() {
        return gQuantity;
    }

    public void setgQuantity(Integer gQuantity) {
        this.gQuantity = gQuantity;
    }

    public String getgMsg() {
        return gMsg;
    }

    public void setgMsg(String gMsg) {
        this.gMsg = gMsg == null ? null : gMsg.trim();
    }

    public Integer getgType() {
        return gType;
    }

    public void setgType(Integer gType) {
        this.gType = gType;
    }
}