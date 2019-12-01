package com.book.mapper;

import java.util.List;

import com.book.pojo.TbOrderAll;

public interface OrderAllMapper {
	
	TbOrderAll selectOrderAllByOrderId(String orderId);
    
	List<TbOrderAll> selectOrderAll();
}
