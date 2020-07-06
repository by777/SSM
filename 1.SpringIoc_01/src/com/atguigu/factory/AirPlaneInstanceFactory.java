package com.atguigu.factory;

import com.atguigu.bean.AirPlane;

public class AirPlaneInstanceFactory {
	
	
	//调用 new AirPlaneInstanceFactory().getAirPlane();
	public  AirPlane getAirPlane(String jzName){
		System.out.println("实力工厂被调用了");
		AirPlane airPlane = new AirPlane();
		airPlane.setJzName(jzName);		
		airPlane.setFdj("奔腾");
		airPlane.setFjzName("大富");
		airPlane.setYc("1111111m");
		airPlane.setPersonNum(300);
		return airPlane;
	}
}
