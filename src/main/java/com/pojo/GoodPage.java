/**
 * @author 李彩清
 */
package com.pojo;

import java.util.List;

/**
 * @author 李彩清
 *
 */

public class GoodPage<Good> {
	// 每页显示数量
	private int limit;
	// 页码
	private int page;
	// sql语句起始索引
	private int offset;
	//该页数据
	
	private int total;
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}


	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

}
