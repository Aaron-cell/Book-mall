package com.book.service;

import java.util.List;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.TreeNode;
import com.book.pojo.TbBookCat;
/**
 * 获取商品分类接口
 * @ClassName: ItemCatService
 * @Title: ItemCatService
 * @author:
 * @date: 2019年8月18日
 */
public interface ItemCatService {
	/**
	 * 获取商品类目
	 * @Title: getItemCatList
	 * @Function: TODO
	 * @Param: @param parentId
	 * @Param: @return
	 * @return: List<TreeNode>
	 * @throws:
	 */
	List<TreeNode> getItemCatList(long parentId);
	/**
	 * 添加商品类目
	 * @Title: creatItemCat
	 * @Function: TODO
	 * @Param: @param parentId
	 * @Param: @param name
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult creatItemCat(long parentId,String name);
	/**
	 * 修改类目名称
	 * @Title: updateItemCat
	 * @Function: TODO
	 * @Param: @param bookCat
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult updateItemCat(TbBookCat bookCat);
	/**
	 * 删除商品类目
	 * @Title: deleteItemCat
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	BookResult deleteItemCat(long id);
}
