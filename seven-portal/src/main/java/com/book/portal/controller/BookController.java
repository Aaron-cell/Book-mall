package com.book.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.pojo.TbBook;
import com.book.portal.pojo.BookDetails;
import com.book.portal.service.BookService;
import com.book.portal.service.IndexService;
/**
 * 图书详情controller
 * @ClassName: BookController
 * @Title: BookController
 * @author: 码农界的小学生
 * @date: 2019年8月23日
 */
@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private IndexService indexService;
	/**
	 * 获取商品详情
	 * @Title: seekBookDetails
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @param model
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/book/details")
	public String seekBookDetails(long id,Model model) {
		BookDetails bookDetails = bookService.selectBookDetails(id);
		List<TbBook> list = indexService.getDetailItemList();
		model.addAttribute("book", bookDetails);
		model.addAttribute("list",list);
		return "details";
	}
}
