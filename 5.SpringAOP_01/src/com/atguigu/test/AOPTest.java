package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.atguigu.impl.MyMathCalculator;
import com.atguigu.inter.Calculator;
import com.atguigu.proxy.CalculatorProxy;
//import com.atguigu.inter.Calculator;
import com.atguigu.util.LogUtils;

public class AOPTest {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Calculator calculator = new MyMathCalculator();
/*		
		calculator.add(1, 2);
		calculator.mul(1, 5);
		calculator.sub(1, 62);
		calculator.div(6, 3);*/
		
		System.out.println("============");
		Calculator proxy;
		proxy = CalculatorProxy.getProxy(calculator);//拿到一个代理对象
		proxy.add(1,5);//用代理对象运行核心逻辑
		proxy.mul(1, 8);
	}

}
