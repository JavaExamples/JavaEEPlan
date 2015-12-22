package com.bookmanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;

public class AboutGuibsInternalFrame extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutGuibsInternalFrame frame = new AboutGuibsInternalFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AboutGuibsInternalFrame() {
		setTitle("关于Guibs");
		getContentPane().setBackground(Color.BLUE);
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JLabel lblAuthorGuibs = new JLabel("Author: Guibs");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(180, Short.MAX_VALUE)
					.addComponent(lblAuthorGuibs)
					.addGap(159))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(111)
					.addComponent(lblAuthorGuibs)
					.addContainerGap(127, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
