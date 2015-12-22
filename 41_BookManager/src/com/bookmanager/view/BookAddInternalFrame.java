package com.bookmanager.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.bookmanager.dao.BookDao;
import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.Book;
import com.bookmanager.model.BookType;
import com.bookmanager.util.DBUtil;
import com.bookmanager.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInternalFrame extends JInternalFrame {
	private JTextField bookNameTF;
	private JTextField authorTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField bookPriceTF;
	private JComboBox bookTypeJCB;
	private JTextArea bookDescTA;
	private JRadioButton manJRB;
	private JRadioButton femaleJRB;
	
	private DBUtil dbUtil = new DBUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();
	private BookDao bookDao = new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInternalFrame frame = new BookAddInternalFrame();
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
	public BookAddInternalFrame() {
		setIconifiable(true);
		setClosable(true);
		setTitle("图书添加");
		setBounds(100, 100, 450, 518);
		
		JLabel label = new JLabel("图书名称:");
		
		bookNameTF = new JTextField();
		bookNameTF.setColumns(10);
		
		JLabel label_1 = new JLabel("图书作者:");
		
		authorTF = new JTextField();
		authorTF.setColumns(10);
		
		JLabel label_2 = new JLabel("作者性别:");
		
		manJRB = new JRadioButton("男");
		buttonGroup.add(manJRB);
		manJRB.setSelected(true);
		
		femaleJRB = new JRadioButton("女");
		buttonGroup.add(femaleJRB);
		
		JLabel label_3 = new JLabel("图书价格:");
		
		bookPriceTF = new JTextField();
		bookPriceTF.setColumns(10);
		
		JLabel label_4 = new JLabel("图书类别:");
		
		bookTypeJCB = new JComboBox();
		
		JLabel label_5 = new JLabel("图书描述:");
		
		bookDescTA = new JTextArea();
		
		JButton addBook = new JButton("添加");
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookAddActionPerformed(e);
			}
		});
		
		JButton reset = new JButton("重置");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypeJCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookNameTF, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(manJRB)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(femaleJRB)))
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authorTF, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookPriceTF, 0, 0, Short.MAX_VALUE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addBook)
									.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
									.addComponent(reset))
								.addComponent(bookDescTA))))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(authorTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(manJRB)
						.addComponent(femaleJRB)
						.addComponent(label_3)
						.addComponent(bookPriceTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(bookTypeJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(bookDescTA, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addBook)
						.addComponent(reset))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		fillBookType();
	}
	
	/**
	 * 重置事件处理
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent e) {
		resetValue();
	}

	/**
	 * 添加图书
	 * @param e
	 */
	protected void bookAddActionPerformed(ActionEvent evt) {
		String bookName = bookNameTF.getText();
		String author = authorTF.getText();
		String price = bookPriceTF.getText();
		String desc = bookDescTA.getText();
		String sex = "";
		
		if (StringUtil.isEmpty(bookName)) {
			JOptionPane.showMessageDialog(null, "图书名称不能为空!");
			return;
		}
		if (StringUtil.isEmpty(author)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空!");
			return;
		}
		if (StringUtil.isEmpty(price)) {
			JOptionPane.showMessageDialog(null, "图书金额不能为空!");
			return;
		}
		
		if (manJRB.isSelected()) {
			sex = "男";
		} else if (femaleJRB.isSelected()) {
			sex = "女";
		}
		
		BookType bookType =  (BookType)bookTypeJCB.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book(bookName, author, sex, Float.parseFloat(price), bookTypeId, desc);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = bookDao.add(con, book);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "图书添加成功");
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "图书添加失败");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "图书添加失败");
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
	 * 初始化图书类别下拉框
	 */
	private void fillBookType() {
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.getBookTypeList(con, bookType);
			System.out.println(rs);
			while(rs.next()) {
				bookType = new BookType(rs.getInt("id"), rs.getString("bookTypeName"), rs.getString("bookTypeDesc"));
				this.bookTypeJCB.addItem(bookType);
			}
		} catch (Exception e) {
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
	 * 重置表单
	 */
	private void resetValue() {
		this.bookNameTF.setText("");
		this.bookPriceTF.setText("");
		this.bookDescTA.setText("");
		this.authorTF.setText("");
		this.manJRB.setSelected(true);
		if(this.bookTypeJCB.getItemCount() > 0) {
			this.bookTypeJCB.setSelectedIndex(0);
		}
	}
}
