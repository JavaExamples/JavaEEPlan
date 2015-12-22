package com.classcontent;

import java.util.Scanner;

public class IfElseSwitch {
	public static void main(String[] args) {
		int a = 0;
		// if
		if (a > 0) {
			System.out.println("a是正数");
		}
		
		
		// if else
		if (a > 0 ) {
			System.out.println("a是正数");
		} else {
			System.out.println("a不是正数");
		}
		
		// if else if
		if (a > 0 ) {
			System.out.println("a是正数");
		} else if (a == 0) {
			System.out.println("a是0");
		} else {
			System.out.println("a是负数");
		}
		
		// Switch
		System.out.println("请输入一个数字");
		Scanner scanner = new Scanner(System.in);
		int c = scanner.nextInt();
		switch (c) {
		case 1: {
			System.out.println("用户输入的是1");
			break;
		}
		case 2: {
			System.out.println("用户输入的是2");
			break;
		}
		default: {
			System.out.println("用户输入的既不是1也不是2");
		}
		}
	}
}
