package com.book.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.book.mapper.TbBookCatMapper;
import com.book.mapper.TbBookMapper;
import com.book.pojo.TbBook;
import com.book.pojo.TbBookCat;
import com.book.pojo.TbBookCatExample;
import com.book.pojo.TbBookExample;
import com.book.pojo.TbBookExample.Criteria;
import com.book.portal.service.IndexService;
@Service
public class IndexServiceImpl implements IndexService {
	//定义三个类别 文学、少儿、励志
	@Value("${MODERN_NOVEL_ID}")
	private long MODERN_NOVEL_ID;
	@Value("${PREGNANCY_ID}")
	private long PREGNANCY_ID;
	@Value("${PSYCHOLOGY_ID}")
	private long PSYCHOLOGY_ID;
	
	@Autowired
	private TbBookMapper bookMapper;
	
	@Autowired TbBookCatMapper bookCatMapper;
	
	
	public List<List<TbBook>> getBookList() {
		List<TbBook> list = seleteItemList(MODERN_NOVEL_ID);
		List<TbBook> list1 = seleteItemList(PREGNANCY_ID);
		List<TbBook> list2 = seleteItemList(PSYCHOLOGY_ID);
		List<List<TbBook>> list3 = new ArrayList<List<TbBook>>();
		list3.add(list);
		list3.add(list1);
		list3.add(list2);
		return list3;
	}

	//3层分类 文、少、励
	public List<TbBook> seleteItemList(long bookCatId) {
		TbBookExample example = new TbBookExample();
		Criteria criteria = example.createCriteria();
		criteria.andCidEqualTo(bookCatId);
		List<TbBook> list = bookMapper.selectByExample(example);
		List<TbBook> list2 = new ArrayList<TbBook>();
		if(list.size()>=5) {
			for (int i = 0; i < 5; i++) {
				list2.add(list.get(i));
			}
			return list2;
		}else {
			return list;
		}
	}
	
	//更多推荐
	@Override
	public List<TbBook> getRecommendBookList() {
		TbBookExample example = new TbBookExample();
		List<TbBook> list = bookMapper.selectByExample(example);
		ArrayList<TbBook> list2 = new ArrayList<>();
		if(list.size()>=50) {
			for(int i=0;i<50;i++) {
				int r =(int)(Math.random()*list.size());
				list2.add(list.get(r));
				list.remove(r);//每取出一个数就从集合删除这个数
			}
		}
		return list2;
	}
		
	//获取商品详情下的推荐商品
	@Override
	public List<TbBook> getDetailItemList() {
		TbBookExample example = new TbBookExample();
		List<TbBook> list = bookMapper.selectByExample(example);
		ArrayList<TbBook> list2 = new ArrayList<>();
		if(list.size()>=5) {
			for(int i=0;i<5;i++) {
				int r =(int)(Math.random()*list.size());
				list2.add(list.get(r));
				list.remove(r);
			}
		}
		return list2;
	}



}
