package com.classcontent;

public class TestClass {
	public static void main(String[] args) {
		
		// 手动装箱和拆箱
		int a = 1;
		Integer i = new Integer(a); // 装箱 [基本变量变为对象变量]
		int b = i.intValue(); // 拆箱 [对象变量变为基本变量]
		System.out.println(a + "=" + i + "=" + b);
		
		// 自动装箱和拆箱
		Integer aI = 1; // 自动装箱过程
		int ai = i; // 自动拆箱
		System.out.println(aI + "=" + ai);
		
		// 包装类作用 (举例)
		String s1 = "1";
		String s2 = "2";
		int m = Integer.parseInt(s1);
		int n = Integer.parseInt(s2);
		System.out.println(m + n);
	}
}
