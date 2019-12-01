package com.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  页面跳转controller                                                                     
 * @ClassName: PageController
 * @Title: PageController
 * @author: 
 * @date: 2019年8月17日
 */
@Controller
public class PageController {
	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}
	
	/**
	 * 数据回显 跳转到item-edit
	 * @Title: itemEdit
	 * @Function: TODO
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/rest/page/item-edit")
	public String itemEdit() {
		return "item-edit";
	}
	@RequestMapping("/rest/page/order-edit")
	public String orderEdit() {
		return "order-edit";
	}
}
