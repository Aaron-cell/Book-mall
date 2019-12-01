package com.book.portal.mapper;
/**
 * 获取商品详情dao层接口
 * @ClassName: BookDetailsMapper
 * @Title: BookDetailsMapper
 * @author: 码农界的小学生
 * @date: 2019年8月23日
 */

import com.book.portal.pojo.BookDetails;

public interface BookDetailsMapper {
	
	BookDetails getBookDetailsById(long id);
}
