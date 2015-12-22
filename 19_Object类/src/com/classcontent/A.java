package com.classcontent;

public class A {
	/*
	 * Object 类是所有类的父类 
	 */
	public A() {
		super();
	}
	
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	// 重写toString 方法, 使其输出更多信息
	@Override
	public String toString() {
		return this.getA();
	}
	
	// 重写equals 方法, 判断内容是否相同
	@Override
	public boolean equals(Object obj) {
		String content = ((A)obj).getA();
		return this.a == content;
	}
	
	public static void main(String[] args) {
		A a = new A();
		A b = new A();
		a.setA("hello");
		System.out.println(a);
		b.setA("hello");
		System.out.println(a.equals(b));
		
		// instanceof 判断对象是否属于一个类
		if (a instanceof A) {
			System.out.println("a属于A");
		}
		if (a instanceof Object) {
			System.out.println("a属于Object");
		}
		boolean s = a instanceof Object;
		System.out.println("===" + s);
	}
}
