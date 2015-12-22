package com.classcontent;

public class Test {
	public static void main(String[] args) {
		// 父类引用指向子类的具体实现 [多态]
		Animal animal = new Dog();
		animal.say();
		
		animal = new Cat();
		animal.say();
		
		// 向下转型 不安全
//		Dog dog = (Dog) animal;
//		dog.say();
//		
//		Cat cat = (Cat) animal;
//		cat.say();
		
	}
}
