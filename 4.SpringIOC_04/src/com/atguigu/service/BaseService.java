package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.atguigu.dao.BaseDao;

// 这里不加Service,但是子类上面注册了，子类里生效
public class BaseService<T> {
	@Autowired
	private BaseDao<T> baseDao;
	
	//service 调用Dao 
	public void save(){
		System.out.println("自动注入的Dao"+baseDao);
		baseDao.save();
	}
}
