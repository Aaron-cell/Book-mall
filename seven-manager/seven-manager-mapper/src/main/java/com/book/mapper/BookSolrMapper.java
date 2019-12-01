package com.book.mapper;

import java.util.List;

import com.book.common.pojo.BookSolr;

/**
 * 图书列表导入solr dao层接口
 * @ClassName: BookMapper
 * @Title: BookMapper
 * @author: 码农界的小学生
 * @date: 2019年8月23日
 */
public interface BookSolrMapper {
	List<BookSolr> getBookSolrList();
	BookSolr selectBookSolrById(String id);
}
