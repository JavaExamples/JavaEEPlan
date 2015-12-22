package com.classcontent_字符流;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Demo {
	public static void main(String[] args) throws IOException {
		
		// reader
		File fileIn = new File("/Users/guibs/Desktop/JavaCreated/JavaCreated.txt");
		Reader reader = new FileReader(fileIn);
		char c[] = new char[1024]; // 字符数组
		// 一次性读取
		int len = reader.read(c);
		// // 一个一个读取 [注意c[] 数组越界问题]
		// int temp = 0;
		// int len = 0;
		// while ((temp = reader.read()) != -1) {
		// c[len++] = (char) temp;
		// }
		reader.close(); // 关闭输入流
		System.out.println("读取的内容是: " + new String(c, 0, len));
		
		// writer
		File fileOut = new File("/Users/guibs/Desktop/JavaCreated/NewJavaCreated.txt");
//		Writer out = new FileWriter(fileOut); // 覆盖原内容
		Writer out = new FileWriter(fileOut, true); // 追加内容
		String str = "我是writer";
		out.write(str);
		out.close();
	}
}
