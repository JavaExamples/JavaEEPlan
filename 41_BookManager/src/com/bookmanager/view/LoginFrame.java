package com.bookmanager.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.bookmanager.dao.UserDao;
import com.bookmanager.model.User;
import com.bookmanager.util.DBUtil;
import com.bookmanager.util.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTF;
	private JPasswordField passwordTF;
	private DBUtil dbUtil = new DBUtil();
	private UserDao userDao = new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setResizable(false);
		setTitle("管理员登陆");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("图书管理系统");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/bookmanager/image/bm_login_logo.png")));
		
		JLabel label = new JLabel("用户名");
		label.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/bookmanager/image/bm_login_un.png")));
		
		userNameTF = new JTextField();
		userNameTF.setColumns(10);
		
		JLabel label_1 = new JLabel(" 密   码");
		label_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/com/bookmanager/image/bm_login_pwd.png")));
		
		passwordTF = new JPasswordField();
		passwordTF.setColumns(10);
		
		JButton loginBTN = new JButton("登入");
		loginBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginActionPerformed(e);
			}
		});
		
		JButton resetBTN = new JButton("重置");
		resetBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(73)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(55)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(userNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(resetBTN)
									.addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(114)
							.addComponent(loginBTN))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(138)
							.addComponent(lblNewLabel)))
					.addContainerGap(119, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel)
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginBTN)
						.addComponent(resetBTN))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		// 设置JFrame居中
		this.setLocationRelativeTo(null);
	}

	/**
	 * 登陆事件处理
	 * @param e
	 */
	protected void loginActionPerformed(ActionEvent e) {
		String userName = this.userNameTF.getText();
		String password = new String(this.passwordTF.getPassword());
		if (StringUtil.isEmpty(userName)) { // 用户名为空
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (StringUtil.isEmpty(password)) { // 密码为空
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		} 
		User user = new User(userName, password);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			User currentUser = userDao.login(con, user);
			if (currentUser != null) {
				// 销毁当前窗体
				dispose();
				// 创建新窗体
				new MainFrame().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
				this.passwordTF.setText("");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
	}

	/**
	 * 清空LoginFram界面填写的内容
	 * @param e
	 */
	protected void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTF.setText("");
		this.passwordTF.setText("");
	}
}
