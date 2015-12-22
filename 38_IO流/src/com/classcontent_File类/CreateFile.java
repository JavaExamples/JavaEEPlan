package com.classcontent_File类;

import java.io.File;
import java.io.IOException;

public class CreateFile {
	public static void main(String[] args) throws IOException {
		// 创建虚拟目录
		File file = new File("/Users/guibs/Desktop/JavaCreated");
		boolean res = file.mkdir();
		if (res) {
			System.out.println("目录创建成功");
			// 创建文件
			file = new File("/Users/guibs/Desktop/JavaCreated/JavaCreated.txt");
			boolean resF = file.createNewFile();
			if (resF) {
				System.out.println("文件创建成功");
			} else {
				System.out.println("文件创建失败");
			}
		} else {
			System.out.println("目录创建失败");
		}
	}
}
