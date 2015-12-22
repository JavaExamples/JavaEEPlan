package com.content_泛型;

public class C2 {
	private String a2;

	public String getA2() {
		return a2;
	}

	public void setA2(String a2) {
		this.a2 = a2;
	}

	public C2(String a2) {
		super();
		this.a2 = a2;
	}
	
	/**
	 * 打印a2的类型
	 */
	public void print() {
		System.out.println("a2的类型是: " + a2.getClass().getName());
	}
	
}
