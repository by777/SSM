package com.atguigu.impl;

import com.atguigu.inter.Calculator;
import com.atguigu.util.LogUtils;

public class MyMathCalculator implements Calculator {

	@Override
	public int add(int i, int j) {
		// TODO Auto-generated method stub
		//System.out.println("【add】方法：" + "(" + i + "," + j + ")");
		//LogUtils.logStart(i,j);
		int result = i + j;
		//System.out.println("【add】方法的结果："+result);
		return result;
	}

	@Override
	public int sub(int i, int j) {
		// TODO Auto-generated method stub
		//System.out.println("【sub】方法：" + "(" + i + "," + j + ")");
		//LogUtils.logStart(i,j);
		int result = i - j;
		//System.out.println("【sub】方法的结果："+result);
		return result;
	}

	@Override
	public int mul(int i, int j) {
		// TODO Auto-generated method stub
		//System.out.println("【mul】方法：" + "(" + i + "," + j + ")");
		//LogUtils.logStart(i,j);
		int result = i * j;
		//System.out.println("【mul】方法的结果："+result);
		return result;
	}

	@Override
	public int div(int i, int j) {
		// TODO Auto-generated method stub
		//System.out.println("【div】方法：" + "(" + i + "," + j + ")");
		//LogUtils.logStart(i,j);
		int result = 0;
		if(j!=0)
			result =(int) i / j;
		//System.out.println("【div】方法的结果："+result);
		return result;
	}

}
