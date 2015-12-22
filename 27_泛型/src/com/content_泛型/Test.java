package com.content_泛型;

public class Test {
	public static void main(String[] args) {
		C1 c1 = new C1(1);
		c1.print();
		
		C2 c2 = new C2("1");
		c2.print();
		
		C12 c121 = new C12(1);	// 向上转型
		int c121i = (Integer) c121.getObject(); // 向下转型
		c121.print();
		System.out.println(c121i);
		
		C12 c122 = new C12("1"); // 向上转型
		String c122s = (String) c122.getObject(); // 向下转型
		c122.print();
		System.out.println(c122s);
		
		// 泛型
			// Integer
		CT<Integer> ct1 = new CT<Integer>(1);
		ct1.print();
		int ct1i = ct1.getOb();
		System.out.println(ct1i);
			// String
		CT<String> ct2 = new CT<String>("1");
		ct2.print();
		String ct2s = ct2.getOb();
		System.out.println(ct2s);
	}
}
