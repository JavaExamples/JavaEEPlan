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

import com.bookmanager.dao.BookTypeDao;
import com.bookmanager.model.BookType;
import com.bookmanager.util.DBUtil;
import com.bookmanager.util.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookTypeManageInternalFrame extends JInternalFrame {
	private JTable bookTypeTable;
	private DBUtil dbUtil = new DBUtil();
	private BookTypeDao bookTypeDao  = new BookTypeDao();
	private JTextField bookTypeNameTF;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInternalFrame frame = new BookTypeManageInternalFrame();
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
	public BookTypeManageInternalFrame() {
		setClosable(true);
		setBounds(100, 100, 450, 300);

		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("图书类别名称");
		
		bookTypeNameTF = new JTextField();
		bookTypeNameTF.setColumns(10);
		
		JButton searchBTN = new JButton("查询");
		searchBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchBTN))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBTN))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);

		bookTypeTable = new JTable();
		bookTypeTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "编号", "图书类别名称", "图书类别描述" }) {
			boolean[] columnEditables = new boolean[] { false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);
	}
	
	/**
	 * 图书类别搜索事件处理
	 * @param e
	 */
	protected void bookTypeSearchActionPerformed(ActionEvent evt) {
		String inputBookTypeName = bookTypeNameTF.getText();
		BookType bookType = new BookType(inputBookTypeName);
		this.fillTable(bookType);
	}

	/**
	 * 更新表格内容
	 * @param bookType
	 */
	private void fillTable(BookType bookType) {
		DefaultTableModel dtm =  (DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0); // 清空表格
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookTypeDao.getBookTypeList(con, bookType);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
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
