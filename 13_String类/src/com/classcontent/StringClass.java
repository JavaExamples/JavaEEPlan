package com.classcontent;

public class StringClass {
	public static void main(String[] args) {
		// 实例化String
		String s1 = "a"; // 直接赋值 [如果创建的字符串在对象池中已存在则不会创建]
		String s2 = new String("a"); // new的方式 [每次new都会创建出字符串对象]
		String s3 = s2; // 传递引用
		
		// == 和 equals
		// == 比较的是引用
		System.out.println(s1 == s2); // false
		System.out.println(s2 == s3); // true
		// equals 比较的是内容
		System.out.println(s1.equals(s2)); // true
		System.out.println(s2.equals(s3)); // true
		
		// 遍历字符串
		String str = "abbccdefg";
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
		}
		
		// 某个字符在字符串中出现的第一个位置的索引 [indexOf] [若无则返回-1]
		System.out.println(str.indexOf("g"));
			// 从某个位置开始
		System.out.println(str.indexOf("c", 4));
		
		// 切割字符串
		String sstr = "不开心么";
		System.out.println(sstr.substring(1));
		System.out.println(sstr.substring(1, 2));
		
		// 大小写转化
		String tstr = "AbcDefG";
		System.out.println(tstr.toUpperCase()); // 转大写
		System.out.println(tstr.toLowerCase()); // 转小写
		
		// 去空格
		String bsstr = "   sdfsa   wer   ";
		System.out.println(bsstr.trim()); // 去掉前后的空白
		for (int i = 0; i < bsstr.trim().length(); i++) {
			char c = bsstr.trim().charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) { // 判断字母
				System.out.println(c);
			} else if (c == ' ') {
				System.out.println("有空格");
			}
		}
	}
}
