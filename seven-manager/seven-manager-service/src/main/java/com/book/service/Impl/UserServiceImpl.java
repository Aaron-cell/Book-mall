package com.book.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.EUDateGridResult;
import com.book.mapper.TbUserMapper;
import com.book.pojo.TbBook;
import com.book.pojo.TbUser;
import com.book.pojo.TbUserExample;
import com.book.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private TbUserMapper userMapper;
	@Override
	public EUDateGridResult getUserList(Integer page, Integer rows,String category,String defaultValue) {
		TbUserExample example = new TbUserExample();
		if(defaultValue!=null && !"".equals(defaultValue)) {
			if("nickname".equals(category)) {
				example.createCriteria().andNicknameLike("%" + defaultValue +"%");
			}else if("username".equals(category)){
				example.createCriteria().andUsernameLike("%" + defaultValue + "%");
			}
		}
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbUser> list = userMapper.selectByExample(example);
		//创建EUDateGridResult对象
		EUDateGridResult result=new EUDateGridResult();
		result.setRows(list);
		//取total值
		PageInfo<TbUser> pageInfo=new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}


	@Override
	public BookResult updateUserInstock(long[] id1) {
		for(long id : id1) {
			TbUser tbUser = new TbUser();
			tbUser.setId(id);
			tbUser.setStatus((byte)0);
			userMapper.updateByPrimaryKeySelective(tbUser);
		}
		return BookResult.ok();
	}


	@Override
	public BookResult updateUserReshelf(long[] id1) {
		for(long id : id1) {
			TbUser tbUser = new TbUser();
			tbUser.setId(id);
			tbUser.setStatus((byte) 1);
			userMapper.updateByPrimaryKeySelective(tbUser);
		}
		return BookResult.ok();
	}
	
}
