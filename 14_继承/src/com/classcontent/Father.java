package com.classcontent;

public class Father {
	private String xing;
	private int money;
	
	public Father() {
		System.out.println("父类无参构造");
	}
	
	public Father(String xing, int money) {
		System.out.println("父类有参构造");
		this.xing = xing;
		this.money = money;
	}
	
	public String getXing() {
		return xing;
	}
	public void setXing(String xing) {
		this.xing = xing;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void say() {
		System.out.println("I can say");
	}
}
