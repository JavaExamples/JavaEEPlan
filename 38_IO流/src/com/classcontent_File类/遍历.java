package com.classcontent_File类;

import java.io.File;

public class 遍历 {
	
	public static void listFile(File file){
		if (file != null) {
			if (file.isDirectory()) { // 是目录
				File f[] = file.listFiles();
				if (f != null) {
					for (int i = 0; i < f.length; i++) {
						listFile(f[i]); // 递归
					}
				}
			} else { // 是文件
				System.out.println(file); // 打印文件路径
			}
		}
	}
	
	public static void main(String[] args) {
		File file = new File("/Users/guibs/Desktop");
		// 遍历某个路径的内容
		File files[] = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			System.out.println(files[i]);
		}
		
		System.out.println("======");
		System.out.println("======");
		System.out.println("======");
		System.out.println("======");
		System.out.println("======");
		
		// 遍历某个路径内所有的文件
//		listFile(file);
	}
}
