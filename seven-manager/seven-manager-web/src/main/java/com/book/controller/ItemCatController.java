package com.book.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.TreeNode;
import com.book.pojo.TbBookCat;
import com.book.service.ItemCatService;
/**
 * 商品Controller
 * @ClassName: ItemController
 * @Title: ItemController
 * @author: 码农界的小学生
 * @date: 2019年8月18日
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;
	/**
	 * 查询图书类别
	 * @Title: getItemCatList
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @return
	 * @return: List<TreeNode>
	 * @throws:
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<TreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0")long id){
		List<TreeNode> itemCatList = itemCatService.getItemCatList(id);
		return itemCatList;
	}
	/**
	 * 创建子目录
	 * @Title: createItemCat
	 * @Function: TODO
	 * @Param: @param parentId
	 * @Param: @param name
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public BookResult createItemCat(long parentId,String name) {
		BookResult result = itemCatService.creatItemCat(parentId, name);
		return result;
	}
	/**
	 * 修改分类目录controller
	 * @Title: updateItemCat
	 * @Function: TODO
	 * @Param: @param bookCat
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public BookResult updateItemCat(TbBookCat bookCat) {
		BookResult result = itemCatService.updateItemCat(bookCat);
		return result;
	}
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public BookResult deleteItemCat(long id) {
		BookResult result = itemCatService.deleteItemCat(id);
		return result;
	}
	
}
