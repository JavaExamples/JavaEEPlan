package com.content_泛型;

public class C1 {
	private Integer a;

	public Integer getA() {
		return a;
	}

	public void setA(Integer a) {
		this.a = a;
	}
	
	public C1(Integer a) {
		super();
		this.a = a;
	}

	/**
	 * 打印a的类型
	 */
	public void print() {
		System.out.println("a的类型是: " + a.getClass().getName());
	}
}
