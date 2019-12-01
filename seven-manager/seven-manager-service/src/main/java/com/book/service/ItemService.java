package com.book.service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.EUDateGridResult;
import com.book.pojo.TbBook;
public interface ItemService {
	/**
	 * 添加商品
	 * @Title: createItem
	 * @Function: TODO
	 * @Param: @param book
	 * @Param: @return
	 * @return: BookResult
	 * @throws Exception 
	 * @throws:
	 */
	BookResult createItem(TbBook book) throws Exception;
	/**
	 * 图书列表展示
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
	/**
	 * 更新商品和描述
	 * @Title: updateItem
	 * @Function: TODO
	 * @Param: @param book
	 * @Param: @param desc
	 * @Param: @return
	 * @return: BookResult
	 * @throws Exception 
	 * @throws:
	 */
	BookResult updateItem(TbBook book,String desc) throws Exception;
	/**
	 * 删除选中商品
	 * @Title: deleteItem
	 * @Function: TODO
	 * @Param: @param str
	 * @Param: @return
	 * @return: BookResult
	 * @throws Exception 
	 * @throws:
	 */
	BookResult deleteItem(long[] str) throws Exception;
	/**
	 * 商品下架
	 * @Title: updateItemStatusInstock
	 * @Function: TODO
	 * @Param: @param id1
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult updateItemStatusInstock(long[] id1);
	/**
	 * 商品上架
	 * @Title: updateItemStatusReshelf
	 * @Function: TODO
	 * @Param: @param id1
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult updateItemStatusReshelf(long[] id1);
	/**
	 * 获取目录下的商品业务
	 * @Title: getContentList
	 * @Function: TODO
	 * @Param: @param categoryId
	 * @Param: @param page
	 * @Param: @param rows
	 * @Param: @return
	 * @return: EUDateGridResult
	 * @throws:
	 */
	EUDateGridResult getContentList(long categoryId, Integer page, Integer rows);
	
	
}
