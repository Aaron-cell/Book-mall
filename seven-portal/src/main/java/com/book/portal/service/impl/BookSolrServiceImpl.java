package com.book.portal.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.BookSolr;
import com.book.mapper.BookSolrMapper;
import com.book.portal.dao.SearchDao;
import com.book.portal.pojo.SearchResult;
import com.book.portal.service.BookSolrService;
@Service
public class BookSolrServiceImpl implements BookSolrService {
	@Autowired
	private BookSolrMapper bookMapper;
	@Autowired
	private SolrServer solrServer;
	@Autowired
	private SearchDao searchDao;

	public BookResult solrImportAll() throws Exception {
	
			//查询书籍列表
			List<BookSolr> list=bookMapper.getBookSolrList();
			//把书籍写入索引库
			for(BookSolr bookSolr : list) {
				SolrInputDocument document = new SolrInputDocument();
				document.setField("id", bookSolr.getId());
				document.setField("book_name", bookSolr.getBookName());
				document.setField("book_sell_point", bookSolr.getSellPoint());
				document.setField("book_author", bookSolr.getAuthor());
				document.setField("book_price", bookSolr.getPrice());
				document.setField("book_image", bookSolr.getImage());
				document.setField("book_cat", bookSolr.getBook_cat());
				document.setField("book_desc", bookSolr.getBookDesc());
				//写入索引库
				solrServer.add(document);
			}
			solrServer.commit();
	
		return BookResult.ok("导入成功");
	}

	@Override
	public SearchResult searchBook(String queryString,int start,int rows) throws Exception {
		//创建查询对象
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(queryString);
		//设置分页
		query.setStart(start);
		query.setRows(rows);
		//设置默认搜索域
		query.set("df", "item_keywords");
		//执行查询
		SearchResult searchResult = searchDao.search(query);
		//计算总页数
		long recordCount = searchResult.getRecordCount();
		long pageCount=recordCount/rows;
		if(recordCount%rows>0) {
			pageCount++;
		}
		searchResult.setPageCount(pageCount);
		return searchResult;
	}

}
