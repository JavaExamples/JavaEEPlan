package com.content_泛型;
/**
 * 泛型类
 * @author guibs
 *
 */
public class CT<T> {
	private T ob;

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}

	public CT(T ob) {
		super();
		this.ob = ob;
	}
	
	public void print() {
		System.out.println("ob的实际类型是: " + ob.getClass().getName());
	}
}
