package com.book.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.CheckBoxResult;
import com.book.service.AddressService;
import com.book.mapper.TbAddressMapper;
import com.book.mapper.TbOrderShippingMapper;
import com.book.pojo.TbAddress;
import com.book.pojo.TbAddressExample;
import com.book.pojo.TbAddressExample.Criteria;
import com.book.pojo.TbOrderShipping;
@Service
public class AddressServiceImpl implements AddressService {
	@Value("${ADDRESS_BASE}")
	private int ADDRESS_BASE;
	
	@Autowired
	private TbAddressMapper addressMapper;
	
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	
	@Override
	public List<CheckBoxResult> getAddressOne() {
		TbAddressExample example = new TbAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(ADDRESS_BASE);
		List<TbAddress> list = addressMapper.selectByExample(example);
		List<CheckBoxResult> result=new ArrayList<CheckBoxResult>();
		for(TbAddress address : list) {
			CheckBoxResult boxResult = new CheckBoxResult();
			boxResult.setId(address.getId());
			boxResult.setText(address.getName());
			result.add(boxResult);
		}
		return result;
	}

	@Override
	public List<CheckBoxResult> getAddressTwo(Integer id) {
		TbAddressExample example = new TbAddressExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(id);
		List<TbAddress> list = addressMapper.selectByExample(example);
		List<CheckBoxResult> result=new ArrayList<CheckBoxResult>();
		for(TbAddress address : list) {
			CheckBoxResult boxResult = new CheckBoxResult();
			boxResult.setId(address.getId());
			boxResult.setText(address.getName());
			result.add(boxResult);
		}
		return result;
	}

	@Override
	public BookResult updateTbOrderShipping(TbOrderShipping orderShipping) {
		TbAddress tbAddress = selectAddressById(Integer.parseInt(orderShipping.getReceiverState()));
		orderShipping.setReceiverState(tbAddress.getName());
		TbAddress tbAddress2 = selectAddressById(Integer.parseInt(orderShipping.getReceiverCity()));
		orderShipping.setReceiverCity(tbAddress2.getName());
		TbAddress tbAddress3 = selectAddressById(Integer.parseInt(orderShipping.getReceiverDistrict()));
		orderShipping.setReceiverDistrict(tbAddress3.getName());
		orderShippingMapper.updateByPrimaryKeySelective(orderShipping);
		return BookResult.ok();
	}
	/**
	 * 查询地址
	 * @Title: selectAddressById
	 * @Function: TODO
	 * @Param: @param id
	 * @Param: @return
	 * @return: TbAddress
	 * @throws:
	 */
	public TbAddress selectAddressById(int id) {
		TbAddress tbAddress = addressMapper.selectByPrimaryKey(id);
		return tbAddress;
	}

}
