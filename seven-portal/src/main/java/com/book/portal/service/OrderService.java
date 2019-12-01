package com.book.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.common.pojo.BookResult;
import com.book.pojo.TbLocation;
/**
 * 订单业务处理
 * @ClassName: OrderService
 * @Title: OrderService
 * @author: 码农界的小学生
 * @date: 2019年8月25日
 */
public interface OrderService {
		/**
		 * 查询地址
		 * @Title: getUserAddress
		 * @Function: TODO
		 * @Param: @param nickname
		 * @Param: @return
		 * @return: List<TbLocation>
		 * @throws:
		 */
	List<TbLocation> getUserAddress(String nickname);
	/**
	 * 删除地址
	 * @Title: deleteAddress
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	 BookResult deleteAddress(long id);
	 
	 BookResult getProvince(Integer parentId);
	 
	 void AddAddress(TbLocation location);

	 void SaveOrderBalance(HttpServletRequest request,HttpServletResponse response,int id,String nickname);
}
