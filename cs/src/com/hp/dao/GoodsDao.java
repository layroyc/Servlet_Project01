package com.hp.dao;

import java.util.ArrayList;

import com.hp.entity.Goods;


public interface GoodsDao {
	//全查
	ArrayList<Goods> selectAll();
	//修改
	int update(Goods goods);
	Goods selectById(int goodsId);
	//添加
	int addGoods(Goods goods);
	//删除
	int delete(int goodsId);
	//单查
	Goods selectone(String goodsName);//用于修改
	//模糊查询
	int selectName(String goodsType,String goodsName,String supplier,String telphone);

}
