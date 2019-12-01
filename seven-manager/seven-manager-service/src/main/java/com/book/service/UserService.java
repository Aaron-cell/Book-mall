package com.book.service;
/**
 * 用户管理业务
 * @ClassName: UserService
 * @Title: UserService
 * @author:
 * @date: 2019年8月19日
 */

import com.book.common.pojo.BookResult;
import com.book.common.pojo.EUDateGridResult;

public interface UserService {
	/**
	 * 获取用户列表
	 * @Title: getUserList
	 * @Function: TODO
	 * @Param: @param page
	 * @Param: @param rows
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	EUDateGridResult getUserList(Integer page,Integer rows,String category,String defaultValue);
	/**
	 * 用户不启用
	 * @Title: updateUser
	 * @Function: TODO
	 * @Param: @param id1
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult updateUserInstock(long[] id1);
	/**
	 * 用户启用
	 * @Title: updateUserReshelf
	 * @Function: TODO
	 * @Param: @param id1
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult updateUserReshelf(long[] id1);
}
