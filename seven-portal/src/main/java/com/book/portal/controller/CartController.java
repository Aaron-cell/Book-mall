package com.book.portal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 * 添加购物车controller
 * @ClassName: CartController
 * @Title: CartController
 * @author: 码农界的小学生
 * @date: 2019年8月24日
 */
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.CartBook;
import com.book.portal.service.CartService;
@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	
	/**
	 * 添加到购物车
	 * @Title: AddBookToCart
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @param number
	 * @Param: @param request
	 * @Param: @param response
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping(value="/add/cart",method=RequestMethod.POST)
	@ResponseBody
	public BookResult AddBookToCart(long id ,@RequestParam(defaultValue="1")Integer number,
			HttpServletRequest request,HttpServletResponse response) {
		BookResult result = cartService.AddBookToCart(id, number, request, response);
		return result;
	}
	/**
	 * 展示购物车
	 * @Title: showCart
	 * @Function: TODO
	 * @Param: @param request
	 * @Param: @param model
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/showCart")
	public String showCart(HttpServletRequest request,Model model) {
		List<CartBook> bookList = cartService.getCartBookList(request);
		model.addAttribute("bookList", bookList);
		return "shopcart";
	}
	/**
	 * 根据id删除商品
	 * @Title: deleteCartBook
	 * @Function: TODO
	 * @Param: @param request
	 * @Param: @param response
	 * @Param: @param id
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/delete/cart")
	public String deleteCartBook(HttpServletRequest request,HttpServletResponse response,long id) {
		cartService.deleteCartBook(request, response, id);
		return "redirect:/showCart";	
	}
	
	@RequestMapping("/deleteCart")
	public String deleteCart(HttpServletRequest request,HttpServletResponse response) {
		cartService.deleteCart(request, response);
		return "redirect:/showCart";
	}
}
