package com.book.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.mapper.TbBookDescMapper;
import com.book.pojo.TbBookDesc;
import com.book.pojo.TbBookDescExample;
import com.book.pojo.TbBookDescExample.Criteria;
import com.book.service.ItemDescService;
@Service
public class ItemDescServiceImpl implements ItemDescService {
	@Autowired
	private TbBookDescMapper bookDescMapper;
	
	@Override
	public BookResult createItemDesc(TbBookDesc bookDesc) {
		bookDescMapper.insert(bookDesc);
		return BookResult.ok();
	}

	@Override
	public BookResult getItemDesc(long bookId) {
		TbBookDesc bookDesc = bookDescMapper.selectByPrimaryKey(bookId);
		return BookResult.ok(bookDesc);
	}

}
