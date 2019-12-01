package com.book.portal.service;
/**
 * 图书详情接口
 * @ClassName: BookService
 * @Title: BookService
 * @author: 码农界的小学生
 * @date: 2019年8月23日
 */

import com.book.pojo.TbBook;
import com.book.portal.pojo.BookDetails;

public interface BookService {
	/**
	 * 获取商品详情方法
	 * @Title: selectBookDetails
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @return
	 * @return: TbBook
	 * @throws:
	 */
	BookDetails selectBookDetails(long id);
}
