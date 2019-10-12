/**
 * @author 李彩清
 */
package com.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李彩清
 *
 */
public class GoodPageHelper<T> {
	 //实体类集合
    private List<T> rows = new ArrayList<T>();
    //数据总条数
    private int total;
 
    public GoodPageHelper() {
        super();
    }
 
    public List<T> getRows() {
        return rows;
    }
 
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
 
    public int getTotal() {
        return total;
    }
 
    public void setTotal(int total) {
        this.total = total;
    }

}
