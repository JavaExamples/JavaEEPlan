package com.classcontent;

public class TestIF {
	public static void main(String[] args) {
		// 父类引用指向子类的具体实现 [多态] 向上转型
		AnimalIF animalIF = new DogIF();
		animalIF.sayIF();

		animalIF = new CatIF();
		animalIF.sayIF();

		// 向下转型 不安全
//		animalIF = (DogIF) animalIF;
//		animalIF.sayIF();

	}
}
