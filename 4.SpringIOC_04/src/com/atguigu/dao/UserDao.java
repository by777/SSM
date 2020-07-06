package com.atguigu.dao;

import org.springframework.stereotype.Repository;

import com.atguigu.bean.User;

@Repository
public class UserDao extends BaseDao<User>{

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("userDao保存用户了");
		
	}

}
