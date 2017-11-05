package com.itqf.bean;

import java.util.List;

public class PageBean<T> {
	private List<T> list;//页面显示的数据集合
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPage;
	public PageBean(List<T> list, int currentPage, int pageSize, int totalCount) {
		
		this.list = list;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	//总页数应该等于总条数除以每页的数量
		public int getTotalPage() {
			return(int) Math.ceil(totalCount*1.0/pageSize);
		}
	
}
