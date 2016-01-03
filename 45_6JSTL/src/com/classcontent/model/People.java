package com.classcontent.model;

public class People {
	private int id;
	private int age;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public People(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	public People() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
