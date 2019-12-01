package com.book.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.EUDateGridResult;
import com.book.pojo.TbAddress;
import com.book.mapper.OrderAllMapper;
import com.book.mapper.TbOrderMapper;
import com.book.mapper.TbOrderShippingMapper;
import com.book.mapper.TbAddressMapper;
import com.book.pojo.TbOrderAll;
import com.book.pojo.TbOrderShipping;
import com.book.service.OrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderAllMapper orderAllMapper;
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	@Override
	public EUDateGridResult getItemList(Integer page, Integer rows, String category, String defaultValue) {
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbOrderAll> list = orderAllMapper.selectOrderAll();
		//创建EUDateGridResult对象		
		EUDateGridResult result=new EUDateGridResult();		
		result.setRows(list);
		//取total值
		PageInfo<TbOrderAll> pageInfo=new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	

}
