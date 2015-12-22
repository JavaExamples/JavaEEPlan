package com.classcontent;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

public class JPanelDemo {
	public static void main(String[] args) {
		// 创建JFrame实例jf
		JFrame jf = new JFrame();
		// 设置jf标题
		jf.setTitle("My JFrame");
		// 设置jf尺寸
		jf.setSize(500, 400);
		
		// 创建JPanel实例
		JPanel jp = new JPanel();
			// 设置JPanel边框
		jp.setBorder(new EmptyBorder(120, 20, 20, 20));
			// 对JPanel设置布局
		jp.setLayout(new GridLayout(3, 2, 10, 10));
			// 设置JPanel背景色
		jp.setBackground(Color.blue);
		// 添加JPanel实例到JFrame实例上
		jf.add(jp);
		
		// 给JPanel添加JButton
		jp.add(new JButton("1"));
		jp.add(new JButton("2"));
		jp.add(new JButton("3"));
		jp.add(new JButton("4"));
		jp.add(new JButton("5"));
		jp.add(new JButton("6"));

		// 设置jf可见
		jf.setVisible(true);
	}
}