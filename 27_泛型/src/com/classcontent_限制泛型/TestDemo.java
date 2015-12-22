package com.classcontent_限制泛型;

public class TestDemo {
	public static void main(String[] args) {
		Demo<Dog> demo1 = new Demo<Dog>(new Dog());
		demo1.print();
		Dog dog = demo1.getOb();
		dog.print();
		
		Demo<Cat> demo2 = new Demo<Cat>(new Cat());
		demo2.print();
		Cat cat = demo2.getOb();
		cat.print();
		
		Demo<Animal> demo3 = new Demo<Animal>(new Animal());
		demo3.print();
		Animal animal = demo3.getOb();
		animal.print();
	}
}
