package com.classcontent;

public class Son extends Father {
	private String computer;
	
	/*
	 * 重写父类的say()
	 */
	@Override
	public void say() {
		System.out.println("我是Son");
	}
	
	public Son() {
		super();
		System.out.println("子类构造方法 -- 无参");
	}

	public Son(String xing, int money) {
		super(xing, money);
		this.computer = "Mac";
		System.out.println("子类构造方法 -- 有参数");
	}

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public static void main(String[] args) {
		Son s = new Son("GW", 111111);
		s.say();
		System.out.println("我姓" + s.getXing() + ", 我有" + s.getMoney() + "元" + "我的电脑是" + s.getComputer());
		s.setXing("王");
		s.setMoney(100000);
		System.out.println("我姓" + s.getXing() + ", 我有" + s.getMoney() + "元" + "我的电脑是" + s.getComputer());
	}
}
