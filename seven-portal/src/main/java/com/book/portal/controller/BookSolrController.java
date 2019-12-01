package com.book.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.pojo.BookResult;
import com.book.portal.service.BookSolrService;
/**
 * solr控制层
 * @ClassName: BookSolrController
 * @Title: BookSolrController
 * @author: 码农界的小学生
 * @date: 2019年8月23日
 */
@Controller
public class BookSolrController {
	@Autowired
	private BookSolrService bookSolrService;
	 
	@RequestMapping("/solr/importAll")
	@ResponseBody
	public BookResult solrImportAll() throws Exception {
		BookResult result = bookSolrService.solrImportAll();
		return result;
	}
	
	
}
