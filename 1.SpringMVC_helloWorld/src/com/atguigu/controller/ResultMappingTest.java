package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/*测试模糊匹配功能
 * ？：能替代任意1个字符
 * *:能替代任意多个字符和一层路径
 * **：能替代多层路径
 * 
 * 当发送的请求同时满足多个匹配时，精确优先
 * 
 * */
@Controller
public class ResultMappingTest {
	@RequestMapping("/antTest01")
	public String antTest01() {
		return "success";
	}
	
	/*0+一个字符（/和？都不行*/）
	@RequestMapping("/antTest0?")
	public String antTest02(){
		return "success";
	}
	
	@RequestMapping("/antTest0*")
	public String antTest03(){
		return "success";
	}
}
