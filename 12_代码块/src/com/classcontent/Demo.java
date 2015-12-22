package com.classcontent;

public class Demo {
	private int i;
	
	/*
	 * 构造块
	 */
	{
		System.out.println("通用构造块");
	}
	
	/*
	 * 静态代码块 [最先执行, 且只在类加载时执行一次]
	 */
	static {
		System.out.println("静态代码块");
	}
	
	public Demo() {
		System.out.println("构造方法一");
	}
	public Demo(int i) {
		this.i = i;
		System.out.println("构造方法二");
	}
	
	public static void main(String[] args) {
		int a = 1;
		
		/*
		 * 普通代码块
		 */
		{
			a = 2;
			System.out.println("普通代码块");
		}
		System.out.println(a);
		
		Demo d1 = new Demo();
		Demo d2 = new Demo(2);
	}
}
