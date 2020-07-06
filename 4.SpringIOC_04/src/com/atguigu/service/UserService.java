package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;

@Service
public class UserService extends BaseService<User>{
	//泛型依赖注入的时候，他的泛型也是参考标准
}
