package com.atguigu.impl;

import org.springframework.stereotype.Service;

import com.atguigu.inter.Calculator;
import com.atguigu.util.LogUtils;

// 目标类加入IOC
@Service
public class MyMathCalculator implements Calculator {
	// Spring中不实现接口也可以创建代理对象，区别是IOC中接收类型是本类型（cjlib功能）
	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		// System.out.println("【add】方法：" + "(" + i + "," + j + ")");
		// LogUtils.logStart(i,j);
		int result = i + j;
		// System.out.println("【add】方法的结果："+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		// System.out.println("【sub】方法：" + "(" + i + "," + j + ")");
		// LogUtils.logStart(i,j);
		int result = i - j;
		// System.out.println("【sub】方法的结果："+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		// System.out.println("【mul】方法：" + "(" + i + "," + j + ")");
		// LogUtils.logStart(i,j);
		int result = i * j;
		// System.out.println("【mul】方法的结果："+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		// System.out.println("【div】方法：" + "(" + i + "," + j + ")");
		// LogUtils.logStart(i,j);
		int result = 0;

		result = (int) i / j;
		// System.out.println("【div】方法的结果："+result);
		return result;
	}

}
