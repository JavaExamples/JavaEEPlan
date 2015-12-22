package com.classcontent;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
public class JFrameDemo {
	public static void main(String[] args) {
		// 创建JFrame实例jf
		JFrame jf = new JFrame();
		// 设置jf的位置
		jf.setLocation(500, 500);
		// 设置jf的尺寸
		jf.setSize(500, 500);
		// 设置jf标题
		jf.setTitle("My JFrame");
		// 设置jf的背景色
			// 获取窗体的contentPane对象
//		Container jfc = jf.getContentPane();
			// 设置jf的contentPane背景色为蓝色
//		jfc.setBackground(Color.BLUE);
		jf.getContentPane().setBackground(Color.BLUE);
		// 设置jf可见
		jf.setVisible(true);
	}
}
