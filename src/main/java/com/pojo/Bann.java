package com.pojo;

import com.util.Page;

public class Bann extends Page{
    private Integer bId;

    private String bTitle;

    private String bContent;

    private String bData;

    private Integer bStatus;
    
    private Integer dateCount;

    public Integer getDateCount() {
		return dateCount;
	}

	public void setDateCount(Integer dateCount) {
		this.dateCount = dateCount;
	}

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

    public Integer getbStatus() {
        return bStatus;
    }

    public void setbStatus(Integer bStatus) {
        this.bStatus = bStatus;
    }
}