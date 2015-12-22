package com.classcontent_InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
	public static void main(String[] args) throws IOException {
		// 测试文件
		File file = new File("/Users/guibs/Desktop/JavaCreated/JavaCreated.txt");
		InputStream inputStream = new FileInputStream(file);
		// 获取文件大小
		int fileLength = (int) file.length();
		// 接受数据的容器
		byte b[] = new byte[fileLength];
		// 读取文件
			// 方式1
		int len = inputStream.read(b);
//			// 方式2
//		int temp = 0;
//		int len = 0;
//		while((temp = inputStream.read()) != -1) {
//			// 一个字节一个字节的读取. 放入b[]
//			b[len++] = (byte) temp;
//		}
		// 关闭输入流
		System.out.println(new String(b));
	}
}
