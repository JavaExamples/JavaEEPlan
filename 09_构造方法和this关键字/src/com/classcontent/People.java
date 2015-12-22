package com.classcontent;

public class People {
	private String name;
	private int age;
	
	// 默认构造方法
	public People() {
		System.out.println("我是默认构造方法");
	}
	// 自定义构造方法(构造方法的重载)
	People(String name, int age) {
		this(); // 调用默认构造方法
		this.name = name; // this调用本类中的属性
		this.age =age;
	}
	
	public void say() {
		System.out.println("我叫" + name + "我今年" + age + "岁了");
	}
	
	public static void main(String[] args) {
		People p = new People("Guibs", 23);
		p.say();
	}
}
