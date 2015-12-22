package com.classcontent;

public class Test implements D {

	@Override
	public void a() {
		System.out.println("a");
	}

	@Override
	public void b() {
		System.out.println("b");
	}

	@Override
	public void d() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.a();
		t.b();
		t.d();
		System.out.println(A.Title);
	}
	
}