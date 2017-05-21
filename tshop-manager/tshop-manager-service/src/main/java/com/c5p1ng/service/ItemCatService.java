package com.c5p1ng.service;

import java.util.List;

import com.c5p1ng.common.pojo.EUTreeNode;

public interface ItemCatService {
	List<EUTreeNode> getCatList(long parentId);
}
