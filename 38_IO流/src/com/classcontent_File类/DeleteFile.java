package com.classcontent_File类;

import java.io.File;

public class DeleteFile {
	public static void main(String[] args) {
		File file = new File("/Users/guibs/Desktop/JavaCreated/JavaCreated.txt");
		if (file.exists()) { // 如果目录存在
			boolean res = file.delete();	// 删除文件
			if (res) {
				System.out.println("删除文件成功");
			} else {
				System.out.println("删除文件失败");
			}
		}
		
		File file2 = new File("/Users/guibs/Desktop/JavaCreated");
		if (file2.exists()) { // 如果目录存在
			boolean res = file2.delete();	// 删除目录
			if (res) {
				System.out.println("删除目录成功");
			} else {
				System.out.println("删除目录失败");
			}
		}
	}
}
