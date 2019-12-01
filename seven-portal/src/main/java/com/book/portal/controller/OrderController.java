package com.book.portal.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.CartBook;
import com.book.common.utils.CookieUtils;
import com.book.pojo.TbLocation;
import com.book.portal.service.CartService;
import com.book.portal.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	/**
	 * 提交订单
	 * @Title: orderBalance
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/order/balance")
	public String orderBalance(HttpServletRequest request,HttpServletResponse response,Model model) {
		String string = request.getParameter("address");
		
		String cookieValue = CookieUtils.getCookieValue(request, "BB_CART", true);
		if(string == null || "".equals(string)) {
			model.addAttribute("msg", "请选择配送地址！");
			return "forward:/order/show"; 
		}else if(cookieValue==null || "".equals(cookieValue) ) {
			model.addAttribute("msg", "购物车为空！");
			return "forward:/order/show"; 
		}else {
			HttpSession session = request.getSession();
			String nickname = (String) session.getAttribute("nickname");
			orderService.SaveOrderBalance(request, response, Integer.parseInt(string), nickname);
			return "redirect:/";
		}
	}
	/**
	 * 展示订单
	 * @Title: orderShow
	 * @Function: TODO
	 * @Param: @param request
	 * @Param: @param model
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/order/show")
	public String orderShow(HttpServletRequest request,HttpServletResponse response,Model model) {
		HttpSession session = request.getSession();
		String nickname = (String) session.getAttribute("nickname");
		List<CartBook> cartBookList = cartService.getCartBookList(request);
		List<TbLocation> list= orderService.getUserAddress(nickname);
		model.addAttribute("num", list.size());
		model.addAttribute("AddressList", list);
		model.addAttribute("bookList", cartBookList);
		return "order";
	}
	/**
	 * 删除地址
	 * @Title: deleteAddress
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping(value="/delete/Address",method=RequestMethod.POST)
	@ResponseBody
	public BookResult deleteAddress(long id) {
		BookResult result = orderService.deleteAddress(id);
		return result;
	}
	@RequestMapping("/order/add/address")
	public String orderAddAddress() {
		return "address";
	}
	
	@RequestMapping(value="/get/addr",method=RequestMethod.POST)
	@ResponseBody
	public BookResult getProvince(@RequestParam(value="parentId",defaultValue="40")Integer parentId) {
		BookResult result = orderService.getProvince(parentId);
		return result;
	}
	
	@RequestMapping("/order/addAddress")
	public String addressAdd(HttpServletRequest request,TbLocation location) {
		String province = request.getParameter("receiverState");
		String city = request.getParameter("receiverCity");
		String receiverDistrict = request.getParameter("receiverDistrict");
		System.out.println(province);
		System.out.println(city);
		System.out.println(receiverDistrict);
		HttpSession session=request.getSession();
		String nickname = (String) session.getAttribute("nickname");
		location.setNickname(nickname);
		location.setReceiverState(province);
		location.setReceiverCity(city);
		location.setReceiverDistrict(receiverDistrict);
		location.setCreated(new Date());
		location.setUpdated(new Date());
		orderService.AddAddress(location);
		return "redirect:/";
	}
	
	
	
}
