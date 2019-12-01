package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.EUDateGridResult;
import com.book.service.UserService;

/**
 * 用户管理Controller
 * @ClassName: UserController
 * @Title: UserController
 * @author:
 * @date: 2019年8月19日
 */
@Controller
public class UserController {
	
	String category="nickname";
	String defaultValue=null;
	@Autowired
	private UserService userService;
	
	/**
	 * 用户列表
	 * @Title: getUserList
	 * @Function: TODO
	 * @Param: @param page
	 * @Param: @param rows
	 * @Param: @return
	 * @return: EUDateGridResult
	 * @throws:
	 */
	@RequestMapping("/user/list")
	@ResponseBody
	public EUDateGridResult getUserList(@RequestParam(value="page", defaultValue="1")Integer page,@RequestParam(value="rows",defaultValue="30")Integer rows) {
		EUDateGridResult result = userService.getUserList(page, rows,category,defaultValue);
		return result;
	}
	
	@RequestMapping("/user/seek/{name}")
	public String seekItem(@PathVariable String name,String value) {
		category=name;
		defaultValue=value;
		return "";
	}
	/**
	 * 不启用用户
	 * @Title: updateUser
	 * @Function: TODO
	 * @Param: @param ids
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping(value="/rest/user/instock",method=RequestMethod.POST)
	@ResponseBody
	public BookResult userInstock(String ids) {
		/*
		 * 将字符串封装成long型数组
		 */
		String[] arr=ids.split(",");
		long[] id1=new long[arr.length];
		for(int i=0;i<arr.length;i++) {
			long id=Long.parseLong(arr[i]);
			id1[i]=id;
		}
		BookResult result = userService.updateUserInstock(id1);
		return result;	
	}
	
	
	@RequestMapping(value="/rest/user/reshelf",method=RequestMethod.POST)
	@ResponseBody
	public BookResult userReshelf(String ids) {
		/*
		 * 将字符串封装成long型数组
		 */
		String[] arr=ids.split(",");
		long[] id1=new long[arr.length];
		for(int i=0;i<arr.length;i++) {
			long id=Long.parseLong(arr[i]);
			id1[i]=id;
		}
		BookResult result = userService.updateUserReshelf(id1);
		return result;	
	}
	
}
