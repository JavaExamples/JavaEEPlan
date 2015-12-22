package com.classcontent;

public class Student extends People {

	@Override
	public void profession() {
		System.out.println("我实现了profession这个方法");
	}
	
	public static void main(String[] args) {
		Student s = new Student();
	}
}
