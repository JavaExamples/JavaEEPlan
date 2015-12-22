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
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BookTypeManageInternalFrame extends JInternalFrame {
	private JTable bookTypeTable;
	private DBUtil dbUtil = new DBUtil();
	private BookTypeDao bookTypeDao  = new BookTypeDao();
	private BookDao bookDao = new BookDao();
	
	private JTextField bookTypeNameSearchTF;
	private JTextField bookTypeIdTF;
	private JTextField bookTypeNameTF;
	private JTextArea bookTypeDescTA;
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
		setBounds(100, 100, 450, 414);

		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("图书类别名称");
		
		bookTypeNameSearchTF = new JTextField();
		bookTypeNameSearchTF.setColumns(10);
		
		JButton searchBTN = new JButton("查询");
		searchBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeSearchActionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u8868\u5355\u64CD\u4F5C", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(49)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeNameSearchTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchBTN))
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameSearchTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBTN))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("图书类别编号:");
		
		bookTypeIdTF = new JTextField();
		bookTypeIdTF.setEnabled(false);
		bookTypeIdTF.setColumns(10);
		
		JLabel label_2 = new JLabel("图书类别名称:");
		
		bookTypeNameTF = new JTextField();
		bookTypeNameTF.setColumns(10);
		
		JLabel label_3 = new JLabel("图书类别描述:");
		
		bookTypeDescTA = new JTextArea();
		
		JButton updateBTN = new JButton("修改");
		updateBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		
		JButton deleteBTN = new JButton("删除");
		deleteBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeDeleteActionEvent(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeIdTF, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeNameTF, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bookTypeDescTA)))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(updateBTN)
						.addComponent(deleteBTN))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookTypeIdTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(bookTypeNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateBTN))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookTypeDescTA, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteBTN))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) { // 鼠标点击事件
				bookTypeTableMousePressed(e);
			}
		});
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
	 * 删除BookType信息
	 * @param e
	 */
	protected void bookTypeDeleteActionEvent(ActionEvent evt) {
		String id = bookTypeIdTF.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请先选择要删除的记录");
			return;
		}
		int result = JOptionPane.showConfirmDialog(null, "确定要删除该记录么?");
		if (result == 0) {
			Connection con = null;
			try {
				con = dbUtil.getCon();
				System.out.println(id);
				boolean flag = bookDao.existBookByBookTypeId(con, id);
				System.out.println(flag);
				if (flag) {
					JOptionPane.showMessageDialog(null, "该类别存在图书记录, 无法删除");
					return;
				}
				int resultDel = bookTypeDao.delete(con, id);
				if (resultDel == 1) {
					JOptionPane.showMessageDialog(null, "删除成功");
					this.resetValue();
					this.fillTable(null);
				} else {
					JOptionPane.showMessageDialog(null, "删除失败");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				con = dbUtil.getCon();
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
	}

	/**
	 * 更改BookType信息
	 * @param e
	 */
	protected void bookTypeUpdateActionEvent(ActionEvent evt) {
		String id = bookTypeIdTF.getText();
		String name = bookTypeNameTF.getText();
		String desc = bookTypeDescTA.getText();
		if (StringUtil.isEmpty(id)) {
			JOptionPane.showMessageDialog(null, "请先选择要修改的记录");
			return;
		}
		if (StringUtil.isEmpty(name)) {
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空");
			return;
		}
		BookType bookType = new BookType(Integer.parseInt(id), name, desc);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int result = bookTypeDao.update(con, bookType);
			if (result == 1) {
				JOptionPane.showMessageDialog(null, "修改成功");
				// 清空表单
				resetValue();
				// 刷新table
				this.fillTable(bookType);
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	 * 表格行点击事件处理
	 * @param e
	 */
	protected void bookTypeTableMousePressed(MouseEvent evt) {
		int row = bookTypeTable.getSelectedRow();
		bookTypeIdTF.setText((String)bookTypeTable.getValueAt(row, 0));
		bookTypeNameTF.setText((String)bookTypeTable.getValueAt(row, 1));
		bookTypeDescTA.setText((String)bookTypeTable.getValueAt(row, 2));
		
	}

	/**
	 * 图书类别搜索事件处理
	 * @param e
	 */
	protected void bookTypeSearchActionPerformed(ActionEvent evt) {
		String inputBookTypeName = bookTypeNameSearchTF.getText();
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
	
	/**
	 * 重置表单
	 */
	private void resetValue() {
		this.bookTypeIdTF.setText("");
		this.bookTypeNameTF.setText("");
		this.bookTypeDescTA.setText("");
	}
}
