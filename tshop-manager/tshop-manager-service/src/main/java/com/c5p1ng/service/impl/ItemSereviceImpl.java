package com.c5p1ng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c5p1ng.common.pojo.EUDataGridResult;
import com.c5p1ng.mapper.TbItemMapper;
import com.c5p1ng.pojo.TbItem;
import com.c5p1ng.pojo.TbItemExample;
import com.c5p1ng.service.ItemService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ItemSereviceImpl implements ItemService {
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TbItem getItemById(long itemId) {
		//TbItem item = itemMapper.selectByPrimaryKey(itemId);
		
		TbItemExample example = new TbItemExample();
		//添加查詢條件
		com.c5p1ng.pojo.TbItemExample.Criteria  criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null&&list.size()>0)
			return list.get(0);
		return null;
	}

	/**
	 * 商品列表查詢
	 */
	@Override
	public EUDataGridResult getItemList(int page, int rows) {
		//查詢商品列表
		TbItemExample example = new TbItemExample();
		//分頁處理
		PageHelper.startPage(page, rows);
		List<TbItem> list = itemMapper.selectByExample(example);
		//創建一個返回值對象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取記錄縂條數
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
}
