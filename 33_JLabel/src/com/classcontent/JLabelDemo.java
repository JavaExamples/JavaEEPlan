package com.classcontent;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelDemo {
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
				jf.setLayout(new GridLayout(4, 5, 10, 20)); // 4行 5列 水平间距10 竖直间距20

				// 创建JLabel实例
				JLabel jl = new JLabel("JLabel组件", JLabel.CENTER); // 居中
				
				// 添加JLabel组件到JFrame
				jf.add(jl);
				// 设置jf可见
				jf.setVisible(true);
	}
}
