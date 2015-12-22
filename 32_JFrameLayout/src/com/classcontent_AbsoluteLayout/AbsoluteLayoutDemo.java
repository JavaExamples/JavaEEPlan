package com.classcontent_AbsoluteLayout;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class AbsoluteLayoutDemo {
	public static void main(String[] args) {
		// 创建JFrame实例jf
		JFrame jf = new JFrame();
		// 设置关闭按钮为结束程序
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置jf的位置
		jf.setLocation(500, 500);
		// 设置jf的尺寸
		jf.setSize(500, 500);
		// 设置jf标题
		jf.setTitle("My JFrame");
		// 设置jf的背景色
		jf.getContentPane().setBackground(Color.BLUE);
		// 设置JFrame的Layout
		jf.setLayout(null);

		// 创建JButton实例
		JButton jb1 = new JButton("按钮1");
		JButton jb2 = new JButton("按钮2");
		// 设置JButton实例位置和大小
		jb1.setBounds(10, 20, 100, 200);
		jb2.setBounds(200, 200, 50, 50);

		// 将JButton添加到JFrame上
		jf.add(jb1);
		jf.add(jb2);

		// 设置jf可见
		jf.setVisible(true);
	}
}
