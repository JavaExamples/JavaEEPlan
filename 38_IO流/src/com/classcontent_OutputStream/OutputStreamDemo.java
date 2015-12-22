package com.classcontent_OutputStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamDemo {
	public static void main(String[] args) throws IOException {
		// 测试文件
		File file = new File("/Users/guibs/Desktop/JavaCreated/JavaCreated.txt");
//		OutputStream out = new FileOutputStream(file); // 覆盖文件方式
		OutputStream out = new FileOutputStream(file, true); // 追加文件内容方式
		String str = "你好 alljfalfjaj";
		byte b[] = str.getBytes();
		out.write(b); // 写入
		out.close(); // 关闭输出流
	}
}
