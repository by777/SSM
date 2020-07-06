package com.atguigu.factory;

import com.atguigu.bean.AirPlane;

public class AirPlaneStaticFactory {
	public static AirPlane getAirPlane(String jzName){
		
		System.out.println("静态工厂被调用了");
		AirPlane airPlane = new AirPlane();
		airPlane.setJzName(jzName);		
		airPlane.setFdj("奔腾");
		airPlane.setFjzName("大富");
		airPlane.setYc("1111111m");
		airPlane.setPersonNum(300);
		return airPlane;
	}
}
