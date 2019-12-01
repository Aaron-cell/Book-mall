package com.book.portal.service;

import java.util.List;

import com.book.pojo.TbBook;
import com.book.pojo.TbBookCat;

/**
 * 
 * @author 42592
 *
 */
public interface IndexService {

	List<List<TbBook>> getBookList();
	/**
	 * 随机查询50个商品
	 * @Title: getRecommendBookList
	 * @Function: TODO
	 * @Param: @return
	 * @return: List<TbBook>
	 * @throws:
	 */
	List<TbBook> getRecommendBookList();
	/**
	 * 获取详情推荐的商品
	 * @Title: getDetailItemList
	 * @Function: TODO
	 * @Param: @return
	 * @return: List<TbBook>
	 * @throws:
	 */
	List<TbBook> getDetailItemList();

}
