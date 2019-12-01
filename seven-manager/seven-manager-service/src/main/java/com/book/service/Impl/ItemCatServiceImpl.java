package com.book.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.common.pojo.BookResult;
import com.book.common.pojo.TreeNode;
import com.book.mapper.TbBookCatMapper;
import com.book.mapper.TbBookMapper;
import com.book.pojo.TbBook;
import com.book.pojo.TbBookCat;
import com.book.pojo.TbBookCatExample;
import com.book.pojo.TbBookCatExample.Criteria;
import com.book.pojo.TbBookExample;
import com.book.service.ItemCatService;

@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired 
	private TbBookCatMapper tbBookCatMapper;
	@Autowired 
	private TbBookMapper tbBookMapper;
	/*
	 * (non-Javadoc)
	 * @see com.book.service.ItemCatService#getItemCatList(long)
	 */
	
	//树 目录的展开
	public List<TreeNode> getItemCatList(long parentId) {
		//根据parentID查询节点列表
		TbBookCatExample example = new TbBookCatExample();   //new一个实例化对象
		Criteria criteria = example.createCriteria();		//创建一个查询条件
		criteria.andParentIdEqualTo(parentId);					//同上
		//执行查询，根据查询条件查找符合要求的数据，并放到集合里
		// 创建查询条件
		//根据查询条件查询
		List<TbBookCat> list = tbBookCatMapper.selectByExample(example);
		List<TreeNode> catList = new ArrayList<TreeNode>();	   
		//将TbBookCat的值赋给TreeNode对象，封装到集合catList里面
		for(TbBookCat bookCat : list) {				
			//创建一个节点
			TreeNode node = new TreeNode();
			node.setId(bookCat.getId());
			//如果是parent就close否则open
			node.setState(bookCat.getIsParent()?"closed":"open");
			node.setText(bookCat.getName());
			catList.add(node);
		}
		return catList;
	}
	
	
	
	/*
	 * 插入一条数据
	 * 并返回此条数据自增的id 封装到对象中
	 * select last_insert_id()
	 * 取当前事务中最后一次生成的id 
	 * 去maapper中改文件
	 * (non-Javadoc)
	 * @see com.book.service.ItemCatService#creatItemCat(long, java.lang.String)
	 */
	public BookResult creatItemCat(long parentId, String name) {
		//根据父id和名字，在数据库插入一条分类的各项数据
		TbBookCat bookCat = new TbBookCat();
		bookCat.setParentId(parentId);
		bookCat.setName(name);
		bookCat.setIsParent(false);  //新建的parent默认为falese
		Date date = new Date();
		bookCat.setCreated(date);
		bookCat.setUpdated(date);
		//添加记录
		tbBookCatMapper.insert(bookCat);
		//查询父类is_parent是否是true 如果不是 则改为true
		TbBookCat tbBookCat = tbBookCatMapper.selectByPrimaryKey(parentId);
		if(!tbBookCat.getIsParent()) {	//判断是否为true
			tbBookCat.setIsParent(true);  //改为true
			//更新父节点
			tbBookCatMapper.updateByPrimaryKey(tbBookCat);
		}
		return BookResult.ok(bookCat);
	}
		
	//更新类目
	public BookResult updateItemCat(TbBookCat bookCat) {
		bookCat.setUpdated(new Date());
		tbBookCatMapper.updateByPrimaryKeySelective(bookCat);
		return BookResult.ok();
	}
	

	
	//删除
	public BookResult deleteItemCat(long id) {
		//判断是否有子目录
		TbBookCat tbBookCat = tbBookCatMapper.selectByPrimaryKey(id);
		if(tbBookCat.getIsParent()) {
			return BookResult.build(403, "无法删除此目录");
		}
		//判断子目录里是否有此类商品
		TbBookExample bookExample = new TbBookExample();
	 com.book.pojo.TbBookExample.Criteria criteria = bookExample.createCriteria();
	 criteria.andCidEqualTo(id);
		List<TbBook> list2 = tbBookMapper.selectByExample(bookExample);
		if(list2!=null && list2.size()>0) {
			return BookResult.build(403, "无法删除此目录");
		}
		//删除此类目
		tbBookCatMapper.deleteByPrimaryKey(id);
		
		//判断父目录是否还有子目录 若没有就改为子目录， 则为false
		TbBookCatExample example1 = new TbBookCatExample();
		Criteria criteria1 = example1.createCriteria();
		criteria1.andParentIdEqualTo(tbBookCat.getParentId());
		List<TbBookCat> list3 = tbBookCatMapper.selectByExample(example1);
		if(list3==null || list3.size()==0) {
			TbBookCat bookCat = new TbBookCat();
			bookCat.setId(tbBookCat.getParentId());
			bookCat.setIsParent(false);
			bookCat.setUpdated(new Date());
			tbBookCatMapper.updateByPrimaryKeySelective(bookCat);
		}
		return BookResult.ok();
	}

}
