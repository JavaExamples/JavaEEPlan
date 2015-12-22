package com.classcontent;

public class ChangeTypte {
	public static void main(String[] args) {
		// 自动类型转换
		short s = 1;
		int i;
		i = s;
		System.out.println(i);
		
		// 强制类型转换
		double d = 1.2;
		float f;
		f = (float)d;
		System.out.println(f);
	}
}
