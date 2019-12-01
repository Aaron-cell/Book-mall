package com.book.portal.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.book.portal.pojo.SearchResult;

public interface SearchDao {
	
	SearchResult search(SolrQuery query)throws Exception;
}
