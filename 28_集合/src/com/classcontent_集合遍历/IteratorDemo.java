package com.classcontent_集合遍历;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorDemo {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("C");
		
		Iterator<String> it = ll.iterator(); // 返回一个迭代器
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}
}
