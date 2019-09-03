package com.pojo;

public class Bann {
    private Integer bId;

    private String bTitle;

    private String bContent;

    private String bData;

    public Integer getbId() {
        return bId;
    }

    public void setbId(Integer bId) {
        this.bId = bId;
    }

    public String getbTitle() {
        return bTitle;
    }

    public void setbTitle(String bTitle) {
        this.bTitle = bTitle == null ? null : bTitle.trim();
    }

    public String getbContent() {
        return bContent;
    }

    public void setbContent(String bContent) {
        this.bContent = bContent == null ? null : bContent.trim();
    }

    public String getbData() {
        return bData;
    }

    public void setbData(String bData) {
        this.bData = bData == null ? null : bData.trim();
    }
}