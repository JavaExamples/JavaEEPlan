package com.bookmanager.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.BookType;
import com.bookmanager.util.DBUtil;
import com.bookmanager.util.StringUtil;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class BookTypeInternalFrame extends JInternalFrame {
	private JTextField bookTypeNameTF;
	private JTextArea bookTypeDescTA;
	private DBUtil dbUtil = new DBUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeInternalFrame frame = new BookTypeInternalFrame();
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
	public BookTypeInternalFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("图书类别添加");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("图书类别名称:");
		
		JLabel label_1 = new JLabel("图书类别描述:");
		
		bookTypeNameTF = new JTextField();
		bookTypeNameTF.setColumns(10);
		
		bookTypeDescTA = new JTextArea();
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeAddPerformed(e);
			}
		});
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reSetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookTypeDescTA)
								.addComponent(bookTypeNameTF)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(button)
							.addGap(54)
							.addComponent(button_1)))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookTypeDescTA, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	/**
	 * 添加图书类别
	 * @param e
	 */
	protected void bookTypeAddPerformed(ActionEvent evt) {
		String bookTypeName = this.bookTypeNameTF.getText();
		String bookTypeDesc = this.bookTypeDescTA.getText();
		if (StringUtil.isEmpty(bookTypeName)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		BookType bookType = new BookType(bookTypeName, bookTypeDesc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int result = bookTypeDao.add(con, bookType);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "图书类别添加成功");
				reSetValue();
			} else {
				JOptionPane.showMessageDialog(null, "图书类别添加失败");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "图书类别添加失败");
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param evt
	 */
	protected void reSetValueActionPerformed(ActionEvent evt) {
		this.reSetValue();
	}

	/**
	 * 清空输入框
	 * @param e
	 */
	private void reSetValue() {
		this.bookTypeNameTF.setText("");
		this.bookTypeDescTA.setText("");
	}
}
