package com.bookmanager.view;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bookmanager.dao.BookDao;
import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.Book;
import com.bookmanager.model.BookType;
import com.bookmanager.util.DBUtil;
import com.bookmanager.util.StringUtil;

import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookManageInternalFrame extends JInternalFrame {
	private JTable bookTable;
	private JTextField bookNameSarchTF;
	private JTextField authorSearchTF;
	private JComboBox bookTypeSearchJCB;
	
	private DBUtil dbUtil = new DBUtil();
	private BookTypeDao bookTypeDao  = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	private JTextField idTF;
	private JTextField nameTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTF;
	private JTextField authorTF;
	private JTextArea descTA;
	private JRadioButton manJRB;
	private JRadioButton womanJRB;
	private JComboBox typeJCB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInternalFrame frame = new BookManageInternalFrame();
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
	public BookManageInternalFrame() {
		setClosable(true);
		setTitle("图书管理");
		setBounds(100, 100, 576, 557);

		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "\u66F4\u65B0\u56FE\u4E66\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 495, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		JLabel label_3 = new JLabel("编号:");
		
		idTF = new JTextField();
		idTF.setEditable(false);
		idTF.setColumns(10);
		
		JLabel label_4 = new JLabel("图书名称:");
		
		nameTF = new JTextField();
		nameTF.setColumns(10);
		
		JLabel label_5 = new JLabel("作者性别:");
		
		manJRB = new JRadioButton("男");
		buttonGroup.add(manJRB);
		manJRB.setSelected(true);
		
		womanJRB = new JRadioButton("女");
		buttonGroup.add(womanJRB);
		
		JLabel label_6 = new JLabel("价格:");
		
		priceTF = new JTextField();
		priceTF.setColumns(10);
		
		JLabel label_7 = new JLabel("图书作者:");
		
		authorTF = new JTextField();
		authorTF.setColumns(10);
		
		JLabel label_8 = new JLabel("图书类别:");
		
		typeJCB = new JComboBox();
		
		JLabel label_9 = new JLabel("图书描述:");
		
		descTA = new JTextArea();
		
		JButton updateBTN = new JButton("修改");
		updateBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookUpdateActionPerformed(e);
			}
		});
		
		JButton deleteBTN = new JButton("删除");
		deleteBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBookActionPerformed(e);
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(idTF, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_6)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(priceTF, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_4)
									.addGap(10)
									.addComponent(nameTF, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_7)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(authorTF, 0, 0, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(manJRB)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(womanJRB))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(label_8)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(typeJCB, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_9)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(updateBTN)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(deleteBTN))
								.addComponent(descTA, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(idTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4)
						.addComponent(nameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5)
						.addComponent(manJRB)
						.addComponent(womanJRB))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(priceTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_7)
						.addComponent(authorTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_8)
						.addComponent(typeJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_9)
						.addComponent(descTA, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(updateBTN)
						.addComponent(deleteBTN))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel label = new JLabel("图书名称:");
		
		bookNameSarchTF = new JTextField();
		bookNameSarchTF.setColumns(10);
		
		JLabel label_1 = new JLabel("图书作者:");
		
		authorSearchTF = new JTextField();
		authorSearchTF.setColumns(10);
		
		JLabel label_2 = new JLabel("图书类别:");
		
		bookTypeSearchJCB = new JComboBox();
		
		JButton SearchBook = new JButton("查询");
		SearchBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(SearchBook)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookNameSarchTF, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(authorSearchTF, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookTypeSearchJCB, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookNameSarchTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(authorSearchTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookTypeSearchJCB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(SearchBook)
					.addGap(14))
		);
		panel.setLayout(gl_panel);

		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		bookTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "编号", "图书名称", "图书作者", "作者性别", "图书价格", "图书描述", "图书类别" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);

		this.fillBookType("search");
		this.fillBookType("change");
		this.fillTable(null);
	}
	
	/**
	 * 图书删除事件处理
	 * @param e
	 */
	protected void deleteBookActionPerformed(ActionEvent e) {
		String id = this.idTF.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showConfirmDialog(null, "请先选择要修改的记录");
			return;
		}
		int n = JOptionPane.showConfirmDialog(null, "是否确认删除?");
		if (n == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int addNum = bookDao.delete(con, id);
				if (addNum == 1) {
					JOptionPane.showMessageDialog(null, "图书删除成功");
					this.fillTable(null);
					resetValue();
				} else {
					JOptionPane.showMessageDialog(null, "图书删除失败");
				}
			} catch (Exception e0) {
				JOptionPane.showMessageDialog(null, "图书删除失败");
				e0.printStackTrace();
			} finally {
				try {
					dbUtil.closeCon(con);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * 更新图书信息
	 * @param e
	 */
	protected void bookUpdateActionPerformed(ActionEvent evt) {
		String id = this.idTF.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showConfirmDialog(null, "请先选择要修改的记录");
			return;
		}
		String bookName = nameTF.getText();
		String author = authorTF.getText();
		String price = priceTF.getText();
		String desc = descTA.getText();
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
		} else if (womanJRB.isSelected()) {
			sex = "女";
		}
		
		BookType bookType =  (BookType)typeJCB.getSelectedItem();
		int bookTypeId = bookType.getId();
		
		Book book = new Book(Integer.parseInt(id), bookName, author, sex, Float.parseFloat(price), bookTypeId, desc);
		
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int addNum = bookDao.update(con, book);
			if (addNum == 1) {
				JOptionPane.showMessageDialog(null, "图书修改成功");
				this.fillTable(null);
				resetValue();
			} else {
				JOptionPane.showMessageDialog(null, "图书修改失败");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "图书修改失败");
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
		this.nameTF.setText("");
		this.idTF.setText("");
		this.descTA.setText("");
		this.priceTF.setText("");
		this.authorTF.setText("");
		this.manJRB.setSelected(true);
		if(this.typeJCB.getItemCount() > 0) {
			this.typeJCB.setSelectedIndex(0);
		}
	}

	/**
	 * 表格行点击事件处理
	 * @param evt
	 */
	protected void bookTableMousePressed(MouseEvent evt) {
		int row = this.bookTable.getSelectedRow();
		this.idTF.setText((String)bookTable.getValueAt(row, 0));
		this.nameTF.setText((String)bookTable.getValueAt(row, 1));
		this.authorTF.setText((String)bookTable.getValueAt(row, 2));
		String sex = (String) bookTable.getValueAt(row, 3);
		if ("男".equals(sex)) {
			this.manJRB.setSelected(true);
		} else if ("女".equals(sex)) {
			this.womanJRB.setSelected(true);
		}
		this.priceTF.setText((Float)bookTable.getValueAt(row, 4) + "");
		this.descTA.setText((String) bookTable.getValueAt(row, 5));
		String bookTypeName = (String) this.bookTable.getValueAt(row, 6);
		int n = this.typeJCB.getItemCount();
		for (int i = 0; i<n; i++) {
			BookType item = (BookType) this.typeJCB.getItemAt(i);
			if (item.getBookTypeName().equals(bookTypeName)) {
				this.typeJCB.setSelectedIndex(i);
			}
		}
		
	}

	/**
	 * 图书查询事件处理
	 * @param e
	 */
	protected void bookSearchActionPerformed(ActionEvent evt) {
		String bookName = this.bookNameSarchTF.getText();
		String author = this.authorSearchTF.getText();
		BookType bookType = (BookType) this.bookTypeSearchJCB.getSelectedItem();
		int bookTypeId = bookType.getId();
		Book book = null;
			 
		if (StringUtil.isEmpty(bookName) && StringUtil.isEmpty(author) && bookTypeId == 0) {
			fillTable(null);
		} else {
			book = new Book(bookName, author, bookTypeId);
			 System.out.println(bookName);
			 System.out.println(author);
			 System.out.println(bookTypeId);
			 fillTable(book);
			 System.out.println("11111");
		}
	}

	/**
	 * 初始化下拉框
	 * @param type 下拉框类型
	 */
	private void fillBookType(String type) {
		Connection con = null;
		BookType bookType = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.getBookTypeList(con, bookType);
			if ("search".equals(type)) {
				bookType = new BookType();
				bookType.setBookTypeName("请选择...");
				this.bookTypeSearchJCB.addItem(bookType);
			}
			while(rs.next()) {
				bookType = new BookType();
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				bookType.setId(rs.getInt("id"));
				if ("search".equals(type)) {
					this.bookTypeSearchJCB.addItem(bookType);
				} else if ("change".equals(type)) {
					this.typeJCB.addItem(bookType);
				}
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
	 * 填充表格
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm =  (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0); // 清空表格
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookDao.getBookList(con, book);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("sex"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v); // 显示该行
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
