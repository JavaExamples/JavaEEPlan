package com.classcontent_集合遍历;

import java.util.LinkedList;

public class ForEachDemo {
	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("C");
		
		for (String s: ll) {
			System.out.println(s);
		}
	}
}
