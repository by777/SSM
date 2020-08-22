package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigu.book.Book;

/*
 * Step1.告诉Spring这是一个处理器可以处理请求@Controller
 * */
@Controller
public class MyFirstController {
	// 斜杠代表从当前项目下开始，省略也一样默认从当前项目下开始的
	/*ResultMapping的其它属性
	 * @RequestMapping(value="/hello",method=RequestMethod.GET,params={"username=bai1",password})
	 * 
	 * method:限定请求方式\GET\POST\PUT\PATCH\DELETE\OPTIONS
	 * 	不按规定请求会报错4xx：客户端错误
	 * 
	 * params:规定请求参数：
	 * 	param1:表示请求必须包含名为param1的参数
	 * 	！parame1：表示请求名不能包含param1的请求参数
	 * 	param1 != value1:包含param1但值不能维value
	 * 	“param1=value1","param2"}:必须包含12，且1为value
	 * 	eg.
	 * 	params={"username"}；请求必须带上username没带会404
	 * 	在发送请求的链接 如果?username= 则为空串 如果？则为Null
	 * 
	 * headers:和params一样可以写简单的表达式：
	 * 	headers={"User-Agent=......firefox"}
	 * 
	 * consumes:直接收内容类型是哪种的请求，规定请求头中的Content-Type
	 * 
	 * produces:告诉浏览器返回内容类型是什么，给响应头中加上Content-Type
	 * 
	 * */
	@RequestMapping("/hello")
	public String myfirstRequest() {
		System.out.println("请求收到了正在处理中");
		// return "/WEB-INF/pages/success.jsp";太长可以去SpringMVC.xml优化
		return "success";// 自动转发到success页面，地址栏仍然是hello请求
		// 注意是转发request.getRequestDispatcher("/test.jsp").forword(request,response);
		// 不是重定向response.sendRedirect("/test.jsp");
	}
	/*SpringMVC获取请求带来的各种信息
	 * @RequestParam: 获取请求参数
	 * @RequestHeader: 请求头中某个key的值
	 * @CookieValue: 获取某个cookie值
	 * 
	 * @PathVariable:获取路径上的占位符
	 * @RequestParam:获取？后面的值
	 * 
	 * */
	// 或者明确的指定@RequestParam(value="user",request=True,defaultValue="")
	@RequestMapping("/handle02")// 名称相同可以直接接收，发送时不带就是null	
	public String handle02(String username,@RequestHeader("User-Agent")String userAgent,
		@CookieValue("JSESSIONID") String jid){
		System.out.println(username);
		System.out.println(userAgent);
		System.out.println(jid);
		return "success";
	}
	@RequestMapping("/book")
	public String handle03(Book book){
		System.out.println("-book--");
		System.out.println("我要保存的图书："+book);
		return "success";
	}
}
