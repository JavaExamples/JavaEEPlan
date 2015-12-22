package com.classcontent_ArrayList和LinkedList;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void print(ArrayList<String> arr) {
		System.out.println("当前集合元素: ");
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		// 添加元素(插入末尾)
		al.add("A");
		al.add("B");
		print(al);
		// 在指定位置插入元素
		al.add(1, "C");
		print(al);
		// 替换指定位置元素
		al.set(0, "D");
		print(al);
		// 移除元素
		al.remove("D");
		print(al);
		al.remove(1);
		print(al);
	}
}
