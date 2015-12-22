package com.classcontent;

public class ThrowsDemo1 {
	public static void testThrows() throws NumberFormatException {
		String str = "123a";
		int a = Integer.parseInt(str);
		System.out.println("I can't be printed");
	}
	
	public static void testThrows(int a) throws Exception {
		if (a == 1) {
			// 直接抛出一个异常类
			throw new Exception("异常类");
		}
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		try {
			testThrows();
		} catch (Exception e) {
			System.out.println("我们在这里处理异常++");
			e.printStackTrace();
		}
		System.out.println("I can be printed");
		
		try {
			testThrows(1);
		} catch (Exception e) {
			System.out.println("我们在这里处理异常==");
			e.printStackTrace();
		}
	}
}
