package com.classcontent;

public class Single1 {
	/**
	 * 单例的类
	 * 构造方法必须私有
	 */
	private Single1() {
		
	}
	
	/**
	 * 饿汉式单例实现
	 */
	private static final Single1 SINGLE1 = new Single1();
	
	/**
	 * 静态工厂方式
	 */
	public static Single1 geSingle1() {
		return SINGLE1;
	}
}
