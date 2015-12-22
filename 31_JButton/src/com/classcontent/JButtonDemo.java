package com.classcontent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonDemo {
	public static void main(String[] args) {
		// 创建JFrame实例jf
		JFrame jf = new JFrame();
		// 设置jf的位置
		jf.setLocation(500, 500);
		// 设置jf的尺寸
		jf.setSize(500, 500);
		// 设置jf标题
		jf.setTitle("JButton Demo");
		
		// 设置关闭按钮为退出程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 创建JButton实例jb
		JButton jb = new JButton("按钮");
		jf.add(jb);
		
		// 设置jf可见
		jf.setVisible(true);
	}
}
