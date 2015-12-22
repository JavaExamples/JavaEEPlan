package com.classcontent;

public class Test {
	public void test(A a) {
		a.a();
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.test(new B());
		
		// 使用匿名内部类
		t.test(new A() {
			@Override
			public void a() {
				System.out.println("只使用一次的匿名内部类");
			}
		});
	}
}
