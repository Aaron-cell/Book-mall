package com.book.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.portal.mapper.BookDetailsMapper;
import com.book.portal.pojo.BookDetails;
import com.book.portal.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDetailsMapper bookDetailsMapper;
	
	/*获取商品详情
	 * (non-Javadoc)
	 * @see com.book.portal.service.BookService#selectBookDetails(long)
	 */
	public BookDetails selectBookDetails(long id) {
		BookDetails bookDetails = bookDetailsMapper.getBookDetailsById(id);
		return bookDetails;
	}

}
