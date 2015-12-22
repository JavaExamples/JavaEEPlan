package com.classcontent;

public class Outer {
	// 私有属性
	private int a = 1;
	
	// 内部类
	class Inner {
		private int b = 1;
		public void showA() {
			System.out.println(a);
		}
	}
	
	// 外部类方法
	public void showA() {
		Inner inner = new Inner();
		inner.showA();
	}
	
	public static void main(String[] args) {
		Outer outer1 = new Outer();
		outer1.showA();
		
		// 直接调用内部类
		Outer outer2 = new Outer(); // 1.实例化外部类对象
		Outer.Inner inner = outer2.new Inner(); // 2.实例化内部类对象
		inner.showA();
	}
}
