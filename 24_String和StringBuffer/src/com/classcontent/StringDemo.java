package com.classcontent;

public class StringDemo {
	public static void main(String[] args) {
		String str = "123";
		str += "abc"; // str重新指向123abc对象
		System.out.println(str);
	}
}
