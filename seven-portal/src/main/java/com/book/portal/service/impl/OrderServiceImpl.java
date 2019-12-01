package com.book.portal.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.CartBook;
import com.book.common.utils.CookieUtils;
import com.book.common.utils.IDUtils;
import com.book.common.utils.JsonUtils;
import com.book.mapper.TbLocationMapper;
import com.book.mapper.TbOrderBookMapper;
import com.book.mapper.TbOrderMapper;
import com.book.mapper.TbOrderShippingMapper;
import com.book.mapper.TbAddressMapper;
import com.book.pojo.TbAddress;
import com.book.pojo.TbAddressExample;
import com.book.pojo.TbLocation;
import com.book.pojo.TbLocationExample;
import com.book.pojo.TbLocationExample.Criteria;
import com.book.pojo.TbOrder;
import com.book.pojo.TbOrderBook;
import com.book.pojo.TbOrderShipping;
import com.book.portal.pojo.Address;
import com.book.portal.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private TbLocationMapper locationMapper;
	@Autowired
	private TbAddressMapper addressMapper;
	@Autowired
	private TbOrderMapper orderMapper;
	@Autowired
	private TbOrderBookMapper orderBookMapper;
	@Autowired
	private TbOrderShippingMapper orderShippingMapper;
	
	@Override
	public List<TbLocation> getUserAddress(String nickname) {
		TbLocationExample example = new TbLocationExample();
		 Criteria criteria = example.createCriteria();
		 criteria.andNicknameEqualTo(nickname);
		 List<TbLocation> list = locationMapper.selectByExample(example);
		 if(list!=null && list.size()>0) {
			return list;
		 }
		return new ArrayList<TbLocation>();
	}

	@Override
	public BookResult deleteAddress(long id) {
		locationMapper.deleteByPrimaryKey(id);
		return BookResult.build(200, "/order/show");
	}

	@Override
	public BookResult getProvince(Integer parentId) {
		TbAddressExample example = new TbAddressExample();
		com.book.pojo.TbAddressExample.Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbAddress> list = addressMapper.selectByExample(example);
		List<Address> list2 = new ArrayList<Address>();
		for(TbAddress address : list) {
			Address addr = new Address();
			addr.setCode(address.getId());
			addr.setName(address.getName());
			list2.add(addr);
		}
		return BookResult.ok(list2);
	}

	@Override
	public void AddAddress(TbLocation location) {
		if(location.getFlag()==1) {
			TbLocationExample example = new TbLocationExample();
			Criteria criteria = example.createCriteria();
			criteria.andNicknameEqualTo(location.getNickname());
			List<TbLocation> list = locationMapper.selectByExample(example);
			for(TbLocation location1 : list) {
				if(location1.getFlag() == 1) {
					location1.setFlag((byte) 0);
					locationMapper.updateByPrimaryKeySelective(location1);
					break;
				}
			}
			
		}
		TbAddress tbAddress = addressMapper.selectByPrimaryKey(Integer.parseInt(location.getReceiverState()));
		location.setReceiverState(tbAddress.getName());
		TbAddress tbAddress1 = addressMapper.selectByPrimaryKey(Integer.parseInt(location.getReceiverCity()));
		location.setReceiverCity(tbAddress1.getName());
		TbAddress tbAddress2 = addressMapper.selectByPrimaryKey(Integer.parseInt(location.getReceiverDistrict()));
		location.setReceiverDistrict(tbAddress2.getName());
		 locationMapper.insert(location);
	}

	@Override
	public void SaveOrderBalance(HttpServletRequest request,HttpServletResponse response,int id,String nickname) {
		 TbLocation location = locationMapper.selectByPrimaryKey((long) id);
		String cookieValue = CookieUtils.getCookieValue(request, "BB_CART", true);
		List<CartBook> list = JsonUtils.jsonToList(cookieValue, CartBook.class);
		float total=0;
		for(CartBook cart : list) {
			TbOrder tbOrder = new TbOrder();
			tbOrder.setOrderId(IDUtils.genItemId()+"");
			tbOrder.setPayment((cart.getPrice()*cart.getNum()/100)+"");
			tbOrder.setStatus(0);
			tbOrder.setCreateTime(new Date());
			tbOrder.setUpdateTime(new Date());
			tbOrder.setShippingName("顺丰");
			tbOrder.setShippingClode(IDUtils.genItemId()+"");
			orderMapper.insertSelective(tbOrder);
			
			TbOrderBook orderBook = new TbOrderBook();
			orderBook.setOrderId(tbOrder.getOrderId());
			orderBook.setNickname(nickname);
			orderBook.setBookId(cart.getId()+"");
			orderBook.setNum(cart.getNum());
			orderBook.setBookName(cart.getBookName());
			orderBook.setPrice(cart.getPrice());
			orderBook.setPicPath(cart.getImage());
			orderBook.setTotalFee((cart.getPrice()*cart.getNum()/100));
			orderBookMapper.insertSelective(orderBook);
			
			TbOrderShipping orderShipping = new TbOrderShipping();
			orderShipping.setOrderId(orderBook.getOrderId());
			orderShipping.setReceiverName(location.getNickname());
			orderShipping.setReceiverMobile(location.getReceiverMobile());
			orderShipping.setReceiverPhone(location.getReceiverPhone());
			orderShipping.setReceiverState(location.getReceiverState());
			orderShipping.setReceiverCity(location.getReceiverCity());
			orderShipping.setReceiverDistrict(location.getReceiverDistrict());
			orderShipping.setReceiverAddress(location.getReceiverAddress());
			orderShipping.setReceiverZip(location.getReceiverZip());
			orderShippingMapper.insertSelective(orderShipping);
		}
		CookieUtils.deleteCookie(request, response, "BB_CART");
		
	}


}
