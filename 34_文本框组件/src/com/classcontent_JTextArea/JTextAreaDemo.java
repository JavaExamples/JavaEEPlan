package com.classcontent_JTextArea;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class JTextAreaDemo {
	public static void main(String[] args) {
		// 创建JFrame实例jf
		JFrame jf = new JFrame();
		// 设置jf的位置
		jf.setLocation(500, 500);
		// 设置jf的尺寸
		jf.setSize(500, 100);
		// 设置jf标题
		jf.setTitle("My JFrame");
		// 设置jf的背景色
		jf.getContentPane().setBackground(Color.BLUE);
		// 设置JFrame的Layout
		jf.setLayout(new GridLayout(1, 2, 10, 20)); // 4行 5列 水平间距10 竖直间距20
		// 创建JLabel实例
		JLabel jb = new JLabel("描述");
		// 创建JTextArea实例
		JTextArea jta = new JTextArea();
		
		// 添加JTExtField实例到JFrame实例上
		jf.add(jb);
		jf.add(jta);

		// 设置jf可见
		jf.setVisible(true);
	}
}
