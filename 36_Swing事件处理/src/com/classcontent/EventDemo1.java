package com.classcontent;
/**
 * 监听按钮
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * 监听器
 */
class JButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand()); // 返回JButton的文本描述
		JOptionPane.showMessageDialog(null, "按钮被点击");
	}
	
}

public class EventDemo1 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("Swing 事件");
		JButton jb = new JButton("按钮");
		
		// 设置监听器
		JButtonListener jbl = new JButtonListener();
		jb.addActionListener(jbl); // 注册事件监听
		
		jf.add(jb);
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
