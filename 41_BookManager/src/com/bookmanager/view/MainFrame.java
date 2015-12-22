package com.bookmanager.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	JDesktopPane desktopPane = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setTitle("图书管理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("基本数据维护");
		menuBar.add(menu);
		
		JMenu menu_2 = new JMenu("图书类别管理");
		menu.add(menu_2);
		
		JMenuItem menuItem_3 = new JMenuItem("图书类别添加");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeInternalFrame bookTypeInternalFrame = new BookTypeInternalFrame();
				bookTypeInternalFrame.setVisible(true);
				desktopPane.add(bookTypeInternalFrame);
			}
		});
		menu_2.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("图书类别维护");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInternalFrame bookTypeManageInternalFrame = new BookTypeManageInternalFrame();
				bookTypeManageInternalFrame.setVisible(true);
				desktopPane.add(bookTypeManageInternalFrame);
			}
		});
		menu_2.add(menuItem_4);
		
		JMenu menu_3 = new JMenu("图书管理");
		menu.add(menu_3);
		
		JMenuItem menuItem_1 = new JMenuItem("图书添加");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInternalFrame bookInternalFrame = new BookAddInternalFrame();
				bookInternalFrame.setVisible(true);
				desktopPane.add(bookInternalFrame);
			}
		});
		menu_3.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("图书维护");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInternalFrame bookManageInternalFrame = new BookManageInternalFrame();
				bookManageInternalFrame.setVisible(true);
				desktopPane.add(bookManageInternalFrame );
			}
		});
		menu_3.add(menuItem_2);
		
		JMenuItem menuItem = new JMenuItem("安全退出");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 弹窗是否确认退出
				int result = JOptionPane.showConfirmDialog(null, "是否确认退出"); // 0是 1否 2取消
				System.out.println(result);
				if (result == 0) {
					dispose();
				}
			}
		});
		menu.add(menuItem);
		
		JMenu menu_1 = new JMenu("关于我们");
		menuBar.add(menu_1);
		
		JMenuItem mntmguibs = new JMenuItem("关于Guibs");
		mntmguibs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 实例化关于Guibs窗口
				AboutGuibsInternalFrame agIF = new AboutGuibsInternalFrame();
				// 显示窗口
				agIF.setVisible(true);
				desktopPane.add(agIF);
			}
		});
		menu_1.add(mntmguibs);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		// 最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
}
