package com.atguigu.impl;

import com.atguigu.inter.Calculator;

public class MyMathCalculator implements Calculator {

	public int add(int i, int j) {

		int result = i + j;

		return result;
	}

	@Override
	public int sub(int i, int j) {

		int result = i - j;

		return result;
	}

	public int mul(int i, int j) {

		int result = i * j;

		return result;
	}


	public int div(int i, int j) {

		int result = 0;

		result = (int) i / j;

		return result;
	}

}
