package com.suxiaomei.admin.util;

import java.util.List;  

public class QueryResult<T> {  
  
    private List<T> list; // 结果集  
    private int totalRow; // 总记录数 
    private int pageIndex;//索引
    private int pageSize;//分页大小
    public QueryResult() {}  
    public QueryResult(List<T> list, int totalRow) {  
        this.list = list;  
        this.totalRow = totalRow;  
    }
    public QueryResult(int pageIndex, int pageSize) {  
        this.pageIndex = pageIndex;  
        this.pageSize = pageSize;  
    }
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow==null?0:totalRow;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}  
}  