package com.classcontent_ArrayList和LinkedList;

import java.util.LinkedList;

public class LinkedListDemo {
	public static void print(LinkedList<String> arr) {
		System.out.println("当前集合元素: ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i) + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("A");
		ll.add("B");
		ll.add("C");
		ll.add("C");
		print(ll);

		// 返回首次出现某元素的索引
		System.out.println(ll.indexOf("C"));
		print(ll);

		// 获取第一个元素, 为空返回null
		System.out.println(ll.peekFirst());
		print(ll);

		// 获取最后一个元素, 为空返回null
		System.out.println(ll.peekLast());
		print(ll);

		// 获取并移除第一个元素, 为空返回null
		System.out.println(ll.pollFirst());
		print(ll);

		// 获取并移除最后一个元素, 为空返回null
		System.out.println(ll.pollLast());
		print(ll);
	}
}
