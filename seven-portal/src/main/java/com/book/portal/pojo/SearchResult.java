package com.book.portal.pojo;

import java.util.List;

import com.book.common.pojo.BookSolr;

public class SearchResult {
	//商品列表
	private List<BookSolr> bookList;
	//总记录数
	private long recordCount;
	//总页数
	private long pageCount;
	//当前页
	private long curpage;
	
	public List<BookSolr> getBookList() {
		return bookList;
	}
	public void setBookList(List<BookSolr> bookList) {
		this.bookList = bookList;
	}
	public long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(long recordCount) {
		this.recordCount = recordCount;
	}
	public long getPageCount() {
		return pageCount;
	}
	public void setPageCount(long pageCount) {
		this.pageCount = pageCount;
	}
	public long getCurpage() {
		return curpage;
	}
	public void setCurpage(long curpage) {
		this.curpage = curpage;
	}	
	
}
