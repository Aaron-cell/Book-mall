package com.book.portal.service;
/**
 * 购物车逻辑
 * @ClassName: CartService
 * @Title: CartService
 * @author: 码农界的小学生
 * @date: 2019年8月24日
 */

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.CartBook;

public interface CartService {
	/**
	 * 添加书籍到购物车
	 * @Title: AddBookToCart
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @param num
	 * @Param: @param request
	 * @Param: @param response
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult AddBookToCart(Long id, Integer num,HttpServletRequest request,HttpServletResponse response);
	
	/**
	 * 获取购物车列表
	 * @Title: getCartBookList
	 * @Function: TODO
	 * @Param: @param request
	 * @Param: @return
	 * @return: List<CartBook>
	 * @throws:
	 */
	List<CartBook> getCartBookList(HttpServletRequest request);
	/**
	 * 根据id删除购物车商品
	 * @Title: deleteCartBook
	 * @Function: TODO
	 * @Param: @param id
	 * @return: void
	 * @throws:
	 */
	void deleteCartBook(HttpServletRequest request,HttpServletResponse response,long id);
	/**
	 * 清空购物车
	 * @Title: deleteCart
	 * @Function: TODO
	 * @Param: @param request
	 * @Param: @param response
	 * @return: void
	 * @throws:
	 */
	void deleteCart(HttpServletRequest request,HttpServletResponse response);
}
