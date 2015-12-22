package com.classcontent_Buffer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferDemo {

	/*
	 * 非缓冲
	 */
	public static void stream() throws IOException {
		File fileIn = new File("/Users/guibs/Desktop/JavaCreated/JavaCreated.txt");
		File fileOut = new File("/Users/guibs/Desktop/JavaCreated/NewJavaCreated.txt");
		InputStream inputStream = new FileInputStream(fileIn);
		OutputStream out = new FileOutputStream(fileOut);
		int b = 0;
		long startTime = System.currentTimeMillis();
		while((b = inputStream.read()) != -1) {
			out.write(b);
		}
		inputStream.close();
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println("非缓冲Time: " + (endTime - startTime));
	}
	
	/*
	 * 缓冲
	 */
	public static void bufferStream() throws IOException {
		File fileIn = new File("/Users/guibs/Desktop/JavaCreated/JavaCreated.txt");
		File fileOut = new File("/Users/guibs/Desktop/JavaCreated/NewJavaCreated.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(fileIn));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileOut));
		int b = 0;
		long startTime = System.currentTimeMillis();
		while((b = bis.read()) != -1) {
			bos.write(b);
		}
		bis.close();
		bos.close();
		long endTime = System.currentTimeMillis();
		System.out.println("缓冲Time: " + (endTime - startTime));
	}
	
	public static void main(String[] args) throws IOException {
		stream();
		bufferStream();
	}
}
