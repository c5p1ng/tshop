package com.c5p1ng.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c5p1ng.common.pojo.EUTreeNode;
import com.c5p1ng.mapper.TbItemCatMapper;
import com.c5p1ng.pojo.TbItemCat;
import com.c5p1ng.pojo.TbItemCatExample;
import com.c5p1ng.pojo.TbItemCatExample.Criteria;
import com.c5p1ng.service.ItemCatService;

/**
 * 商品分类管理
 * 
 * @author 11984
 *
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EUTreeNode> getCatList(long parentId) {
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		List<EUTreeNode> resultList = new ArrayList<EUTreeNode>();
		for (TbItemCat tbItemCat : list) {
			EUTreeNode node = new EUTreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent() ? "closed" : "open");
			resultList.add(node);
		}
		return resultList;
	}

}
