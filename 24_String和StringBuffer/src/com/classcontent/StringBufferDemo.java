package com.classcontent;

public class StringBufferDemo {
	public static void main(String[] args) {
		// StringBuffer 始终操作同一个对象
		StringBuffer sb = new StringBuffer();
		sb.append("abc");
		System.out.println(sb);
	}
}
