package com.book.portal.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.portal.pojo.SearchResult;
import com.book.portal.service.BookSolrService;
/**
 * 商品搜索controller
 * @ClassName: SearchController
 * @Title: SearchController
 * @author: 码农界的小学生
 * @date: 2019年8月23日
 */
@Controller
public class SearchController {
	
	@Autowired
	private BookSolrService bookSolrService;
	/*
	 * name 搜索名
	 * pager.offset 指针
	 */
	@RequestMapping(value="/search/book")
	public String SearchShow(HttpServletRequest request,
			HttpServletResponse response,Model model) throws Exception {
		String offer=request.getParameter("pager.offset");
		String queryString=request.getParameter("q");
		if(queryString !=null) {
			try {
				queryString=new String(queryString.getBytes("iso8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		int start=0;
    	if(offer==null){
       	  start=0;//用于初始化分页
       	}else {
    		start=Integer.parseInt(offer);//将分页索引赋值给start
       	}

    	//默认设置为每页10条
    	SearchResult searchResult = bookSolrService.searchBook(queryString, start, 10);
    	model.addAttribute("list", searchResult.getBookList());
    	model.addAttribute("count", searchResult.getRecordCount());
    	model.addAttribute("queryString", queryString);
		return "search";
	}
}
