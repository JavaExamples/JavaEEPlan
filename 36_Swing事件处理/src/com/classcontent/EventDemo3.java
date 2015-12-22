package com.classcontent;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/*
 * 使用Adapter创建监听器
 */
class MyWindowAdapter extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("窗口关闭");
	}
}

public class EventDemo3 {
	public static void main(String[] args) {
		JFrame jf = new JFrame("Swing 事件");
		
		// 创建监听适配器
//		MyWindowAdapter mwa = new MyWindowAdapter();
//		jf.addWindowListener(mwa);
			// 匿名类实现事件监听Adapter
		jf.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Closing");
			}
		});

		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
