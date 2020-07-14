package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Step1.告诉Spring这是一个处理器可以处理请求@Controller
 * */
@Controller
public class MyFirstController {
	// 斜杠代表从当前项目下开始
	@RequestMapping("/hello")
	public String myfirstRequest() {
		System.out.println("请求收到了正在处理中");
		// return "/WEB-INF/pages/success.jsp";太长可以去SpringMVC.xml优化
		return "success";// 自动转发到success页面，地址栏仍然是hello请求

	}
}
