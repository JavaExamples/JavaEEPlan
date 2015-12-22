package com.classcontent_泛型方法;

import com.classcontent_限制泛型.Animal;
import com.classcontent_限制泛型.Cat;

public class Test {
	public static <T extends Animal> void f(T t) {
		System.out.println("T的类型是: " + t.getClass().getName());
	}
	
	public static void main(String[] args) {
//		f("");
//		f(1);
		f(new Cat());
	}
}
