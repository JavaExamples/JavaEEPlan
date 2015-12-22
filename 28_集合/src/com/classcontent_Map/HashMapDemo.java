package com.classcontent_Map;

import java.util.HashMap;
import java.util.Iterator;

public class HashMapDemo {
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("A", 1);
		hm.put("B", 2);
		hm.put("C", 3);
		
		// 通过key, 获取value
		int value1 = hm.get("A");
		System.out.println(value1);
		
		// 遍历HashMap
		Iterator<String> it = hm.keySet().iterator(); // 获取key的Set集合的迭代器
		while(it.hasNext()) {
			String key = it.next();
			System.err.println(hm.get(key));
		}
	}
}
