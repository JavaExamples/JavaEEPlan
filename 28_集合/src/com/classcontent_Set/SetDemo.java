package com.classcontent_Set;
/*
 * Set 元素不能重复
 */

import java.util.HashSet;
import java.util.Iterator;

public class SetDemo {
	public static void main(String[] args) {
		/**
		 * 1. HashSet 是无序的
		 * 2. 不允许有重复的值
		 */
		HashSet<String> hs = new HashSet<String>();
		hs.add("1");
		hs.add("2");
		hs.add("3");
		hs.add("4");
		hs.add("0");
		hs.add("3");// 元素不可重复验证, set中仍只有一个3
		
		Iterator<String> it = hs.iterator();
		while(it.hasNext()) {
			String s = it.next();
			System.out.println(s);
		}
	}
}
