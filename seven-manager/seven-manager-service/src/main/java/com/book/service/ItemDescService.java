package com.book.service;
/**
 *
 * @ClassName: ItemDesc
 * @Title: ItemDesc
 * @author:
 * @date: 2019年8月18日
 */

import com.book.common.pojo.BookResult;
import com.book.pojo.TbBookDesc;

public interface ItemDescService {
	/**
	 * 创建商品描述
	 * @Title: createItemDesc
	 * @Function: TODO
	 * @Param: @param bookDesc
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult createItemDesc(TbBookDesc bookDesc);
	/**
	 * 获取商品描述
	 * @Title: getItemDesc
	 * @Function: TODO
	 * @Param: @param bookId
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult getItemDesc(long bookId);
}
