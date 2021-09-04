package com.hp.dao;

import com.hp.entity.User;

public interface UserDao {
	//登录
	User selectUP(String name,String pwd);
	//注册
	int zhuCe(String name,String pwd,String phone);

}
