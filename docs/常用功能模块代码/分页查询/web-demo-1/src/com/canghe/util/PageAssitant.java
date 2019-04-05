package com.canghe.util;

import java.io.Serializable;

/**
 * 页面助手
 * @author Administrator
 *
 */
public class PageAssitant implements Serializable {

	/** 总记录数 */ //数据表中符合要求的数据的条数, 由查询语句查询得到
	private int count;
	/** 总页数 */ //符合条件的数据总共可以分为多少页显示, 由总记录数和页面大小计算得到
	private int totalPage;
	/** 页面大小 */ //每页显示的数据条数, 由页面传递的参数决定
	private int pageSize = 5;
	/** 当前页 */ //当前需要查询的页面序号, 由页面传递的参数决定
	private int currPage = 1;
	/** 起始记录编号 */ //从哪条数据开始查询, 由当前页和页面大小决定
	private int start = 0;
	
	@Override
	public String toString() {
		return "PageAssitant [count=" + count + ", totalPage=" + totalPage + ", pageSize=" + pageSize + ", currPage="
				+ currPage + ", start=" + start + "]";
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		setTotalPage();
	}

	public int getTotalPage() {
		return totalPage;
	}

	private void setTotalPage() {
		
		this.totalPage = this.count / this.pageSize;
		//判断, 是否可以整除
		if(this.count % this.pageSize != 0) {
			this.totalPage++;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setTotalPage();
		setStart();
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
		setStart();
	}

	public int getStart() {
		return start;
	}

	private void setStart() {
		this.start = (this.currPage-1) * this.pageSize;
	}
	
}
