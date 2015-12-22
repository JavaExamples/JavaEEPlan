package com.classcontent_通配符泛型;

import com.classcontent_限制泛型.Cat;
import com.classcontent_限制泛型.Demo;
import com.classcontent_限制泛型.Dog;

public class Test {
	
	private static void takeHome(Demo<?> a) {
		System.out.println("带回家了一个什么呢?");
		a.print();
	}
	
	public static void main(String[] args) {
		Demo<Dog> demo1 = new Demo<Dog>(new Dog());
		takeHome(demo1);
		Demo<Cat> demo2 = new Demo<Cat>(new Cat());
		takeHome(demo2);
	}
}
