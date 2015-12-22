package com.classcontent;

// final 修饰的类不能被继承
public final class Father extends GrandFather {
	/*
	 * 1. static 静态常量 直接类名调用
	 * 2. final 声明的变量不能被修改, 即为常量
	 */
	private static final int a = 1;
	
	public static void main(String[] args) {
		Father f = new Father();
		System.out.println(Father.a);
	}
}
