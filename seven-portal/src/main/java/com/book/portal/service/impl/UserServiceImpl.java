package com.book.portal.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.mapper.TbUserMapper;
import com.book.pojo.TbUser;
import com.book.pojo.TbUserExample;
import com.book.pojo.TbUserExample.Criteria;
import com.book.portal.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private TbUserMapper userMapper;
	
	@Override
	public TbUser login(String username) {
		TbUser user = userMapper.findByNameAndPas(username);
		if(user!=null) {
			return user;			
		}
		return null;
	}

	@Override
	public void regist(TbUser user) {
		Date date = new Date();
		user.setCreated(date);
		user.setUpdated(date);
		userMapper.insertSelective(user);
	}

	@Override
	public void updateUserStatus(TbUser user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public BookResult checkUsername(String username) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = userMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			return BookResult.build(403, "用户名存在");
		}
		return BookResult.ok();
	}

	@Override
	public BookResult checkNickname(String nickname) {
		TbUserExample example = new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andNicknameEqualTo(nickname);
		List<TbUser> list = userMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			return BookResult.build(403, "用户昵称存在");
		}
		return BookResult.ok();
	}

	@Override
	public void update(TbUser user) {
		Date date = new Date();
		user.setUpdated(date);
		userMapper.updateByPrimaryKeySelective(user);
	}
}
