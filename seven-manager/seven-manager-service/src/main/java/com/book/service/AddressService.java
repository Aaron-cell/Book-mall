package com.book.service;

import java.util.List;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.CheckBoxResult;
import com.book.pojo.TbOrderShipping;

/**
 * 下拉框业务处理接口
 * @ClassName: AddressService
 * @Title: AddressService
 * @author: 
 * @date: 2019年8月22日
 */
public interface AddressService {
	/**
	 * 获取一级目录业务
	 * @Title: getAddressOne
	 * @Function: TODO
	 * @Param: @return
	 * @return: List<CheckBoxResult>
	 * @throws:
	 */
	List<CheckBoxResult> getAddressOne();
	/**
	 * 获取二 三级业务
	 * @Title: getAddressTwo
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @return
	 * @return: List<CheckBoxResult>
	 * @throws:
	 */
	List<CheckBoxResult> getAddressTwo(Integer id);
	/**
	 * 更新OrderShipping
	 * @Title: updateTbOrderShipping
	 * @Function: TODO
	 * @Param: @param orderShipping
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult updateTbOrderShipping(TbOrderShipping orderShipping);
}
