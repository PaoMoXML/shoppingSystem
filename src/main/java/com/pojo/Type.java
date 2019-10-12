package com.pojo;

public class Type {
    private Integer tId;

    private String tName;

    private Integer tStatus;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public Integer gettStatus() {
        return tStatus;
    }

    public void settStatus(Integer tStatus) {
        this.tStatus = tStatus;
    }
}