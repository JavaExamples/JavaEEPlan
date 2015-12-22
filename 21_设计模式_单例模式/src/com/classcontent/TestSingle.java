package com.classcontent;

public class TestSingle {
	public static void main(String[] args) {
		Single1 single11 = Single1.geSingle1();
		Single1 single12 = Single1.geSingle1();
		System.out.println("饿汉创建: " + (single11 == single12));
		
		Single2 single21 = Single2.getSingle2();
		Single2 single22 = Single2.getSingle2();
		System.out.println("饿汉创建: " + (single21 == single22));
	}
}
