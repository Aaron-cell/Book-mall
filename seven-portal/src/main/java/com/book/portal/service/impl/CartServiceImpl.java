package com.book.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.CartBook;
import com.book.common.utils.CookieUtils;
import com.book.common.utils.JsonUtils;
import com.book.mapper.TbBookMapper;
import com.book.pojo.TbBook;
import com.book.portal.service.CartService;
@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private TbBookMapper bookMapper;
	
	@Override
	public BookResult AddBookToCart(Long id, Integer num, HttpServletRequest request, HttpServletResponse response) {
		//判断是否上架
		TbBook book = bookMapper.selectByPrimaryKey(id);
		if(book.getStatus()==2) {
			return BookResult.build(403, "商品已下架");
		}
		//cookie的存储有上限 所以这里要减少存储量
		CartBook cartBook = new CartBook();
		cartBook.setId(book.getId());
		cartBook.setAuthor(book.getAuthor());
		cartBook.setBookName(book.getBookName());
		cartBook.setImage(book.getImage());
		cartBook.setPrice(book.getPrice());
		cartBook.setNum(num);
		//加入购物车
		BookResult result = AddBookToCookie(cartBook, request, response);		
		return result;
	}
	
	/**
	 * 添加商品到购物车
	 * @Title: AddBookToCookie
	 * @Function: TODO
	 * @Param: @param cartBook
	 * @Param: @param request
	 * @Param: @param response
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	public BookResult AddBookToCookie(CartBook cartBook,HttpServletRequest request, HttpServletResponse response) {
		try {
			String cookieValue = CookieUtils.getCookieValue(request, "BB_CART", true);
			if(cookieValue == null || "".equals(cookieValue)) {
				List<CartBook> list = new ArrayList<>();
				list.add(cartBook);
				//写入cookie
				CookieUtils.setCookie(request, response, "BB_CART", JsonUtils.objectToJson(list), true);
				return BookResult.ok();
			}
			List<CartBook> List = JsonUtils.jsonToList(cookieValue, CartBook.class);
			CartBook cart=null;
			long id=cartBook.getId();
			for(CartBook  cb : List) {
				//判断cookie中是否有此商品
				if(cb.getId()== id ) {
					cb.setNum(cb.getNum()+cartBook.getNum());
					cart=cb;
				}
				break;
			}
			//如果bookid未与购物车商品id重复
			if(cart==null) {
				List.add(cartBook);
			}
			//写入cookie
			CookieUtils.setCookie(request, response, "BB_CART", JsonUtils.objectToJson(List), true);
			return BookResult.ok();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return BookResult.build(403, "添加购物车失败");
		}
		
	}

	@Override
	public List<CartBook> getCartBookList(HttpServletRequest request) {
		try {
			String cookieValue = CookieUtils.getCookieValue(request, "BB_CART", true);
			if(cookieValue == null) {
				return new ArrayList<CartBook>();
			}
			List<CartBook> list = JsonUtils.jsonToList(cookieValue, CartBook.class);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<CartBook>();
		}
	}

	@Override
	public void deleteCartBook(HttpServletRequest request,HttpServletResponse response,long id) {
		String cookieValue = CookieUtils.getCookieValue(request, "BB_CART", true);
		List<CartBook> List = JsonUtils.jsonToList(cookieValue, CartBook.class);
		for(CartBook book : List) {
			if(book.getId() == id) {
				List.remove(book);
				break;
			}
		}
		CookieUtils.setCookie(request, response, "BB_CART", JsonUtils.objectToJson(List), true);
	}

	@Override
	public void deleteCart(HttpServletRequest request, HttpServletResponse response) {
		CookieUtils.deleteCookie(request, response, "BB_CART");
	}
}
