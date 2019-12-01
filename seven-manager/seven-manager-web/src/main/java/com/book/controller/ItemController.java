package com.book.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 图书添加Controller
 * @ClassName: ItemController
 * @Title: ItemController
 * @author:
 * @date: 2019年8月18日
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.EUDateGridResult;
import com.book.common.utils.IDUtils;
import com.book.pojo.TbBook;
import com.book.pojo.TbBookDesc;
import com.book.service.ItemDescService;
import com.book.service.ItemService;
@Controller
public class ItemController {
	String category="bookName";
	String defaultValue=null;
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private ItemDescService itemDescService;
	
	@RequestMapping(value="/item/save",method=RequestMethod.POST)
	@ResponseBody
	public BookResult createItem(TbBook book,String desc) throws Exception {
		//商品id
		long itemId = IDUtils.genItemId();
		//创建时间 更新时间
		Date date = new Date();
		//不全图书信息
		book.setId(itemId);
		book.setStatus((byte)1);
		book.setCreated(date);
		book.setUpdated(date);
		BookResult result = itemService.createItem(book);
		TbBookDesc bookDesc = new TbBookDesc();
		bookDesc.setBookId(itemId);
		bookDesc.setBookDesc(desc);
		bookDesc.setCreated(date);
		bookDesc.setUpdated(date);
		BookResult result2 = itemDescService.createItemDesc(bookDesc);
		if(result.getStatus()==200 && result2.getStatus()==200) {
			return BookResult.ok();
		}
		
		return BookResult.build(403, "商品添加失败");
	}
	/**
	 * 显示商品列表
	 * @Title: getItemList
	 * @Function: TODO
	 * @Param: @param page
	 * @Param: @param rows
	 * @Param: @return
	 * @return: EUDateGridResult
	 * @throws:
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDateGridResult getItemList(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="rows",defaultValue="30")Integer rows) {
		EUDateGridResult result=itemService.getItemList(page, rows,category,defaultValue);
		return result;
	}
	/**
	 * 商品精确查找
	 * @Title: seekItem
	 * @Function: TODO
	 * @Param: @param name
	 * @Param: @param value
	 * @Param: @return
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/item/seek/{name}")
	public String seekItem(@PathVariable String name,String value) {
		category=name;
		defaultValue=value;
		return "";
	}
	
	/**
	 * 编辑商品时 向页面加载商品描述
	 * @Title: getItemDesc
	 * @Function: TODO
	 * @Param: @param bookId
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping("/rest/item/query/item/desc/{bookId}")
	@ResponseBody
	public BookResult getItemDesc(@PathVariable long bookId) {
		BookResult result = itemDescService.getItemDesc(bookId);
		return result;
	}
	/**
	 * 更新商品信息和商品描述
	 * @Title: updateItem
	 * @Function: TODO
	 * @Param: @param book
	 * @Param: @param desc
	 * @Param: @return
	 * @return: BookResult
	 * @throws Exception 
	 * @throws:
	 */
	@RequestMapping(value="/rest/item/update",method=RequestMethod.POST)
	@ResponseBody
	public BookResult updateItem(TbBook book,String desc) throws Exception {
		BookResult result = itemService.updateItem(book, desc);
		return result;
	}
	/**
	 * 删除商品信息和商品描述
	 * @Title: deleteItem
	 * @Function: TODO
	 * @Param: @param ids
	 * @Param: @return
	 * @return: BookResult
	 * @throws Exception 
	 * @throws:
	 */
	@RequestMapping(value="/rest/item/delete",method=RequestMethod.POST)
	@ResponseBody
	public BookResult deleteItem(String ids) throws Exception {
		/*
		 * 将字符串封装成long型数组
		 */
		String[] arr=ids.split(",");
		long[] id1=new long[arr.length];
		for(int i=0;i<arr.length;i++) {
			long id=Long.parseLong(arr[i]);
			id1[i]=id;
		}
		BookResult result = itemService.deleteItem(id1);
		return result;	
	}
	/**
	 * 商品下架
	 * @Title: itemInstock
	 * @Function: TODO
	 * @Param: @param ids
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	@RequestMapping(value="/rest/item/instock",method=RequestMethod.POST)
	@ResponseBody
	public BookResult itemInstock(String ids) {
		/*
		 * 将字符串封装成long型数组
		 */
		String[] arr=ids.split(",");
		long[] id1=new long[arr.length];
		for(int i=0;i<arr.length;i++) {
			long id=Long.parseLong(arr[i]);
			id1[i]=id;
		}
		BookResult result = itemService.updateItemStatusInstock(id1);
		return result;
	}
	/**
	 * 商品上架
	 * @Title: itemReshelf
	 * @Function: TODO
	 * @Param: @param ids
	 * @Param: @return
	 * @return: TaotaoResult
	 * @throws:
	 */
	@RequestMapping(value="/rest/item/reshelf",method=RequestMethod.POST)
	@ResponseBody
	public BookResult itemReshelf(String ids) {
		/*
		 * 将字符串封装成long型数组
		 */
		String[] arr=ids.split(",");
		long[] id1=new long[arr.length];
		for(int i=0;i<arr.length;i++) {
			long id=Long.parseLong(arr[i]);
			id1[i]=id;
		}
		BookResult result = itemService.updateItemStatusReshelf(id1);
		return result;
	}
	
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EUDateGridResult getContentList(long categoryId, Integer page, Integer rows) {
		EUDateGridResult result = itemService.getContentList(categoryId, page, rows);
		return result;
	}
}
