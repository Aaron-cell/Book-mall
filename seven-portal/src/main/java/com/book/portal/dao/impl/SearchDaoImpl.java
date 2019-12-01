package com.book.portal.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.book.common.pojo.BookSolr;
import com.book.portal.dao.SearchDao;
import com.book.portal.pojo.SearchResult;
@Repository
public class SearchDaoImpl implements SearchDao {
	@Autowired
	private SolrServer solrServer;
	
	@Override
	public SearchResult search(SolrQuery query) throws Exception {
		//返回值对象
		SearchResult result = new SearchResult();
		//根据查询条件查询索引库
		QueryResponse response = solrServer.query(query);
		//获取查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		//获取查询总数量
		result.setRecordCount(solrDocumentList.getNumFound());
		
		List<BookSolr> list = new ArrayList<>();
		//获取商品列表
		for(SolrDocument solrDocument : solrDocumentList) {
			//创建一个商品对象
			BookSolr book=new BookSolr();
			book.setId(  (String) solrDocument.get("id"));
			book.setBookName((String) solrDocument.get("book_name"));
			book.setSellPoint((String) solrDocument.get("book_sell_point"));
			book.setAuthor((String) solrDocument.get("book_author"));
			book.setBook_cat((String) solrDocument.get("book_cat"));
			book.setImage((String) solrDocument.get("book_image"));
			book.setPrice((Long) solrDocument.get("book_price"));
			list.add(book);
		}
		result.setBookList(list);
		return result;
	}
	
	
}
