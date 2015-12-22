package com.classcontent;

public class Person {
	String name;
	int age;
	char sex;
	float height;
	float weight;
	
	public void sayName(String name) {
		System.out.println("我叫" + name);
	}
	
	public static void main(String[] args) {
		// 定义并实例化一个Person对象
		Person p = new Person();
		// 设置对象属性
		p.name = "Guibs";
		// 调用对象方法
		p.sayName(p.name);
	}
}
