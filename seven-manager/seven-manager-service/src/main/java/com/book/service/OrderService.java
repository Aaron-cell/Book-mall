package com.book.service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.EUDateGridResult;
import com.book.pojo.TbOrderShipping;

/**
 * 订单逻辑业务处理接口
 * @ClassName: OrderService
 * @Title: OrderService
 * @author: 
 * @date: 2019年8月21日
 */
public interface OrderService {
	/**
	 * 获取订单列表
	 * @Title: getItemList
	 * @Function: TODO
	 * @Param: @param page
	 * @Param: @param rows
	 * @Param: @param category
	 * @Param: @param defaultValue
	 * @Param: @return
	 * @return: EUDateGridResult
	 * @throws:
	 */
	EUDateGridResult getItemList(Integer page, Integer rows, String category, String defaultValue);

}
