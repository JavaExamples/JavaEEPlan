package com.classcontent;

public class Operator {
	public static void main(String[] args) {
		float a = 1;
		float b = 2;
		
		// + 运算符
		System.out.println(a+b);
		// - 运算符
		System.out.println(a - b);
		// * 运算符
		System.out.println(a * b);
		// / 运算符
		System.out.println(a / b);
		// % 运算符
		System.out.println(a % b);
		
		// ++ 运算符
		// 先赋值后自增
		float a1 = a++;
		System.out.println(a1);
		// 先自增再赋值
		float a2 = ++a;
		System.out.println(a2);
		
		// && 与 前后两个操作数必须都是true才返回true, 否则返回false 若第一个为false, 则不计算第二个
		boolean b1 = (5 > 3) && (4 > 5);
		System.out.println(b1);
		
		// & 不短路与 前后两个操作数必须都是true才返回true, 否则返回false 即使第一个为false, 也计算第二个
		boolean b2 = (5 > 3) & (4 > 5);
		System.out.println(b2);
		
		// || 或 只要两个操作数中有一个为true, 就返回true, 否则返回false
		boolean b3 = (2 < 3) || (4 < 5);
		System.out.println(b3);
		
		// | 不短路或
		boolean b4 = (2 < 3) || (4 < 5);
		System.out.println(b4);
		
		// ! 非 如果操作数是true, 则返回false. 若为false, 则返回true.
		boolean b5 = !(3 < 4);
		System.out.println(b5);
		
		// ^ 异或 当两个操作数不相同时返回true, 相同时返回false
		boolean b6 = (5 > 4) ^ (6 > 3);
		System.out.println(b6);
		
		// >
		System.out.println(1 > 2);
		
		// <
		System.out.println(1 < 2);
		
		// >=
		System.out.println( 2 >= 2);
		
		// <=
		System.out.println(2 <= 2);
		
		// ==
		System.out.println(3 == 4);
		
		// 三目运算符
		String s = 2 > 3? "是": "不是";
		System.out.println(s);
	}
}
