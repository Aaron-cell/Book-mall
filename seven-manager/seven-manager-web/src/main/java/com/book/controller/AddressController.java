package com.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.pojo.CheckBoxResult;
import com.book.service.AddressService;
/**
 * 地址下拉框
 * @ClassName: AddressController
 * @Title: AddressController
 * @author: 
 * @date: 2019年8月22日
 */
@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;
	/**
	 * 获取一级目录
	 * @Title: getAddressOne
	 * @Function: TODO
	 * @Param: @return
	 * @return: List<CheckBoxResult>
	 * @throws:
	 */
	@RequestMapping("/get/receiverState")
	@ResponseBody
	public List<CheckBoxResult> getAddressOne(){
		List<CheckBoxResult> result = addressService.getAddressOne();
		return result;
	}
	/**
	 * 获取二 三级目录
	 * @Title: getAddressTwo
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @return
	 * @return: List<CheckBoxResult>
	 * @throws:
	 */
	@RequestMapping("/get/receiverCity")
	@ResponseBody
	public List<CheckBoxResult> getAddressTwo(Integer id){
		List<CheckBoxResult> result = addressService.getAddressTwo(id);
		return result;
	}
}
