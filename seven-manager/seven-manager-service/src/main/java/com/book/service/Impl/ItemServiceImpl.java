package com.book.service.Impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.BookSolr;
import com.book.common.pojo.EUDateGridResult;
import com.book.mapper.BookSolrMapper;
import com.book.mapper.TbBookDescMapper;
import com.book.mapper.TbBookMapper;
import com.book.pojo.TbBook;
import com.book.pojo.TbBookDesc;
import com.book.pojo.TbBookExample;
import com.book.pojo.TbBookExample.Criteria;
import com.book.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbBookMapper bookMapper;
	
	@Autowired
	private TbBookDescMapper bookDescMapper;
	
	@Autowired
	private SolrServer solrServer;
	
	@Autowired
	private BookSolrMapper bookSolrMapper;

	
	@Override
	public BookResult createItem(TbBook book) throws Exception {
		bookMapper.insert(book);
		BookSolr bookSolr = bookSolrMapper.selectBookSolrById(book.getId()+"");
		SolrInputDocument document = new SolrInputDocument();
		document.setField("id", bookSolr.getId());
		document.setField("book_name", bookSolr.getBookName());
		document.setField("book_sell_point", bookSolr.getSellPoint());
		document.setField("book_author", bookSolr.getAuthor());
		document.setField("book_price", bookSolr.getPrice());
		document.setField("book_image", bookSolr.getImage());
		document.setField("book_cat", bookSolr.getBook_cat());
		document.setField("book_desc", bookSolr.getBookDesc());
		solrServer.add(document);
		solrServer.commit();
		return BookResult.ok();
	}
	
	@Override
	public EUDateGridResult getItemList(Integer page,
			Integer rows,String category,String defaultValue) {
		TbBookExample example=new TbBookExample();
		if(defaultValue!=null && !"".equals(defaultValue)) {
			if("bookName".equals(category)) {
				example.createCriteria().andBookNameLike("%" + defaultValue +"%");
			}else if("author".equals(category)){
				example.createCriteria().andAuthorLike("%" + defaultValue + "%");
			}
		}
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbBook> list=bookMapper.selectByExample(example);
		//创建EUDateGridResult对象
		EUDateGridResult result=new EUDateGridResult();
		result.setRows(list);
		//取total值
		PageInfo<TbBook> pageInfo=new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	
	@Override
	public BookResult updateItem(TbBook book, String desc) throws Exception {
		Date date = new Date();
		book.setUpdated(date);
		bookMapper.updateByPrimaryKeySelective(book);
		BookResult result = updateItemDesc(book.getId(), desc);
		if(result.getStatus()!=200) {
			new Exception("更新失败");
		}
		BookSolr bookSolr = bookSolrMapper.selectBookSolrById(book.getId()+"");
		SolrInputDocument document = new SolrInputDocument();
		document.setField("id", bookSolr.getId());
		document.setField("book_name", bookSolr.getBookName());
		document.setField("book_sell_point", bookSolr.getSellPoint());
		document.setField("book_author", bookSolr.getAuthor());
		document.setField("book_price", bookSolr.getPrice());
		document.setField("book_image", bookSolr.getImage());
		document.setField("book_cat", bookSolr.getBook_cat());
		document.setField("book_desc", bookSolr.getBookDesc());
		solrServer.add(document);
		solrServer.commit();
		return BookResult.ok();
	}
	
	/**
	 * 更新图书描述
	 * @Title: updateItemDesc
	 * @Function: TODO
	 * @Param: @param bookId
	 * @Param: @param desc
	 * @Param: @return
	 * @return: BookResult
	 * @throws:
	 */
	private BookResult updateItemDesc(long bookId,String desc) {
		TbBookDesc bookDesc = new TbBookDesc();
		bookDesc.setBookId(bookId);
		bookDesc.setBookDesc(desc);
		Date date = new Date();
		bookDesc.setUpdated(date);
		bookDescMapper.updateByPrimaryKeySelective(bookDesc);		
		return BookResult.ok();
	}

	@Override
	public BookResult deleteItem(long[] str) throws Exception {
		for(long id : str) {
			bookMapper.deleteByPrimaryKey(id);
			BookResult result = deleteItemDesc(id);
			if(result.getStatus()!=200) {
				new Exception("删除失败");
			}
			//删除solr索引
			SolrInputDocument document = new SolrInputDocument();
			solrServer.deleteById(id+"");
			solrServer.commit();
		}
		return BookResult.ok();
	}
	
	public BookResult deleteItemDesc(long bookId) {
		bookDescMapper.deleteByPrimaryKey(bookId);
		return BookResult.ok();
	}

	@Override
	public BookResult updateItemStatusInstock(long[] id1) {
		//循环将商品下架
		for(long itemId : id1) {
			TbBook book= new TbBook();
			book.setId(itemId);
			book.setStatus((byte) 2);
			book.setUpdated(new Date());
			bookMapper.updateByPrimaryKeySelective(book);
		}
		return BookResult.ok();
	}

	@Override
	public BookResult updateItemStatusReshelf(long[] id1) {
		//循环将商品上架
		for(long itemId : id1) {
			TbBook book = new TbBook();
			book.setId(itemId);
			book.setStatus((byte) 1);
			book.setUpdated(new Date());
			bookMapper.updateByPrimaryKeySelective(book);
		}
		return BookResult.ok();
	}

	@Override
	public EUDateGridResult getContentList(long categoryId, Integer page, Integer rows) {
		TbBookExample example = new TbBookExample();
		 PageHelper.startPage(page, rows);
		 Criteria criteria = example.createCriteria();
		 criteria.andCidEqualTo(categoryId);
		 List<TbBook> list = bookMapper.selectByExample(example);
		 EUDateGridResult result = new EUDateGridResult();
		 result.setRows(list);
		 PageInfo<TbBook> pageInfo = new PageInfo<>(list);
		 result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	
}
