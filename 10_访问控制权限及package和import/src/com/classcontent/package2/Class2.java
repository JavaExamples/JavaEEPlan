package com.classcontent.package2;

import com.classcontent.package1.Class1;

public class Class2 {
	public static void main(String[] args) {
		Class1 c1 = new Class1();
		c1.setA(2);
		int c1a = c1.getA();
		System.out.println(c1a);
	}
}
