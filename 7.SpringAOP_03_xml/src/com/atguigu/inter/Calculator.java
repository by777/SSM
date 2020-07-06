package com.atguigu.inter;

// 接口一般不加載@容器中，實際上加了Spring也會智能不創建
public interface Calculator {
	public int add(int i, int j);
	public int sub(int i, int j);
	public int mul(int i, int j);
	public int div(int i, int j);
}
