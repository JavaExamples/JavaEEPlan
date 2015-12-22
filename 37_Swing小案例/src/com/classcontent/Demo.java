package com.classcontent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Demo {
	public static void main(String[] args) {
		JFrame jf = new JFrame("加法计算");
		jf.setLayout(null); // 使用绝对布局
		jf.setSize(600, 300);

		JTextField num1JTF = new JTextField();
		// JLabel addJL = new JLabel("+");
		// 选择运算的下拉框
		// 下拉框内容
		String ope[] = { "+", "-", "*", "/" };
		JComboBox jcb = new JComboBox(ope);
		JTextField num2JTF = new JTextField();
		JButton eqlJB = new JButton("=");
		JLabel resJLB = new JLabel("0");

		eqlJB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 获取num1 num2
				String num1 = num1JTF.getText();
				String num2 = num2JTF.getText();
				Integer result = null;
				// 获取运算种类
				String opa = (String) jcb.getSelectedItem();
				switch (opa) {
				case "+":
					// 计算num1 + num2 的和
					result = Integer.parseInt(num1) + Integer.parseInt(num2);
					resJLB.setText(result.toString());
					break;
				case "-":
					// 计算num1 + num2 的和
					result = Integer.parseInt(num1) - Integer.parseInt(num2);
					resJLB.setText(result.toString());
					break;
				case "*":
					// 计算num1 + num2 的和
					result = Integer.parseInt(num1) * Integer.parseInt(num2);
					resJLB.setText(result.toString());
					break;
				case "/":
					// 计算num1 + num2 的和
					result = Integer.parseInt(num1) / Integer.parseInt(num2);
					resJLB.setText(result.toString());
					break;
				default:
					break;
				}
				System.out.println(result);
			}
		});

		// 设置组件位置和尺寸
		num1JTF.setBounds(20, 30, 50, 25);
		jcb.setBounds(80, 30, 40, 25);
		num2JTF.setBounds(130, 30, 50, 25);
		eqlJB.setBounds(190, 30, 50, 25);
		resJLB.setBounds(300, 30, 50, 25);

		// 添加组件到jf
		jf.add(num1JTF);
		jf.add(jcb);
		jf.add(num2JTF);
		jf.add(eqlJB);
		jf.add(resJLB);

		jf.setVisible(true);
	}
}
