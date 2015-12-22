package com.classcontent_FlowLayout;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowLayoutDemo {
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
		jf.getContentPane().setBackground(Color.BLUE);
		// 设置JFrame的Layout
//		jf.setLayout(new FlowLayout());
			// 设置FLowLayout为左对齐
			jf.setLayout(new FlowLayout(FlowLayout.LEFT));
			// 设置间距, 左右15, 上下20
			jf.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 20));
		// 创建9个JButton实例
		JButton jb = null;
		for (int i = 0; i < 9; i++) {
			jb = new JButton("JButton" + i);
			// 添加JButton到JFrame
			jf.add(jb);
		}
		
		// 设置jf可见
		jf.setVisible(true);
	}
}
