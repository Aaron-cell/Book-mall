package com.book.portal.service;
/**
 * 搜索服务
 * @ClassName: BookSolrService
 * @Title: BookSolrService
 * @author: 码农界的小学生
 * @date: 2019年8月22日
 */

import com.book.common.pojo.BookResult;
import com.book.portal.pojo.SearchResult;

public interface BookSolrService {
	/**
	 * 导入所有数据
	 * @Title: solrImportAll
	 * @Function: TODO
	 * @Param: @return
	 * @return: BookResult
	 * @throws Exception 
	 * @throws:
	 */
	BookResult solrImportAll() throws Exception;
	/**
	 * 根据条件查询
	 * @Title: searchBook
	 * @Function: TODO
	 * @Param: @param queryString
	 * @Param: @return
	 * @return: SearchResult
	 * @throws Exception 
	 * @throws:
	 */
	SearchResult searchBook(String queryString,int start,int rows) throws Exception;
}
