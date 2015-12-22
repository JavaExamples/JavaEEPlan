package com.classcontent_BorderLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo {
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
		jf.setLayout(new BorderLayout());

		// 创建JButton实例
		JButton jbE = new JButton("东");
		JButton jbW = new JButton("西");
		JButton jbS = new JButton("南");
		JButton jbN = new JButton("北");
		JButton jbC = new JButton("中");

		// 将JButton放入JFrame
		jf.add(jbE, BorderLayout.EAST);
		jf.add(jbW, BorderLayout.WEST);
		jf.add(jbS, BorderLayout.SOUTH);
		jf.add(jbN, BorderLayout.NORTH);
		jf.add(jbC, BorderLayout.CENTER);

		// 设置jf可见
		jf.setVisible(true);
	}
}
