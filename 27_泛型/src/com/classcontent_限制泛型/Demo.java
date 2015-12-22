package com.classcontent_限制泛型;

public class Demo < T extends Animal> {
	private T ob;

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	public Demo(T ob) {
		super();
		this.ob = ob;
	}
	
	public void print() {
		System.out.println("ob的类型是: " + ob.getClass().getName());
	}
}
