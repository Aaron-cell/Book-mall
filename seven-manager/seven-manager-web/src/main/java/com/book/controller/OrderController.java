package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * 订单控制器
 * @ClassName: OrderController
 * @Title: OrderController
 * @author: 
 * @date: 2019年8月21日
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.EUDateGridResult;
import com.book.pojo.TbOrderShipping;
import com.book.service.AddressService;
import com.book.service.OrderService;

@Controller
public class OrderController {
	private String category="orderId";
	private String defaultValue=null;
	@Autowired 
	private OrderService orderService;
	@Autowired
	private AddressService addressService;
	/**
	 * 显示订单集合controller
	 * @Title: getItemList
	 * @Function: TODO
	 * @Param: @param page
	 * @Param: @param rows
	 * @Param: @return
	 * @return: EUDateGridResult
	 * @throws:
	 */
	@RequestMapping("/order/list")
	@ResponseBody
	public EUDateGridResult getOrderList(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="rows",defaultValue="30")Integer rows) {
		EUDateGridResult result=orderService.getItemList(page, rows,category,defaultValue);
		return result;
	}
	
	@RequestMapping(value="/rest/order/update",method=RequestMethod.POST)
	@ResponseBody
	public BookResult updateOrderShipping(TbOrderShipping orderShipping) {
		
		BookResult result = addressService.updateTbOrderShipping(orderShipping);
		return result;
	}
	
}
