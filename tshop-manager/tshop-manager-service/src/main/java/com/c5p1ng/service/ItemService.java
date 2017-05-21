package com.c5p1ng.service;

import com.c5p1ng.common.pojo.EUDataGridResult;
import com.c5p1ng.pojo.TbItem;

public interface ItemService {
	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page,int rows);
}
