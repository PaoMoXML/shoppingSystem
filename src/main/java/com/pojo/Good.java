package com.pojo;

public class Good extends GoodPage{
    /**
	 * @return the gType
	 */
	public String getgType() {
		return gType;
	}

	/**
	 * @param gType the gType to set
	 */
	public void setgType(String gType) {
		this.gType = gType;
	}

	private Integer gId;

    private String gName;

    private Float gPrecost;

    private Float gCost;

    private Integer gQuantity;

    private String gMsg;

    private String gType;

    private Integer gStatus;

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

   

    public Integer getgStatus() {
        return gStatus;
    }

    public void setgStatus(Integer gStatus) {
        this.gStatus = gStatus;
    }

	/**
	 * @return the gPrecost
	 */
	public Float getgPrecost() {
		return gPrecost;
	}

	/**
	 * @param gPrecost the gPrecost to set
	 */
	public void setgPrecost(Float gPrecost) {
		this.gPrecost = gPrecost;
	}

	/**
	 * @return the gCost
	 */
	public Float getgCost() {
		return gCost;
	}

	/**
	 * @param gCost the gCost to set
	 */
	public void setgCost(Float gCost) {
		this.gCost = gCost;
	}

	@Override
	public String toString() {
		return "Good [gId=" + gId + ", gName=" + gName + ", gPrecost=" + gPrecost + ", gCost=" + gCost + ", gQuantity="
				+ gQuantity + ", gMsg=" + gMsg + ", gType=" + gType + ", gStatus=" + gStatus + "]";
	}

	
	
}