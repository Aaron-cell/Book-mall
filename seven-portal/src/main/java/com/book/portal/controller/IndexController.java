package com.book.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.pojo.TbBook;
import com.book.pojo.TbBookCat;
import com.book.portal.service.IndexService;

/**
 * 跳转到首页
 * @ClassName: IndexController
 * @Title: IndexController
 * @author: ***
 * @date: 2019年8月19日
 */
@Controller
public class IndexController {

	
	@Autowired
	private IndexService indexService;
	/**
	 * 根据类别获取图书展示在首页
	 * @return
	 */
	
	//3层
	@RequestMapping("/")
	public String IndexShow(HttpServletRequest request) {
		List<List<TbBook>> list = indexService.getBookList();
		request.setAttribute("list0", list.get(0));
		request.setAttribute("list1", list.get(1));
		request.setAttribute("list2", list.get(2));
		//更多推荐
		List<TbBook> list3 = indexService.getRecommendBookList();
		request.setAttribute("list3", list3);
		
		return "index";
	}
	/**
	 * 各个页面实现跳转
	 * @Title: PageShow
	 * @Function: TODO
	 * @Param: @param page
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/{page}")
	public String PageShow(@PathVariable String page) {
		return page;
	}

}
