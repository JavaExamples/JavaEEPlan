package com.classcontent_继承Thread;

public class Thread1 extends Thread {
	private int baoZi = 1;
	private String threadName;
	
	public Thread1(String threadName) {
		super();
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		while (baoZi <= 10) {
			System.out.println(threadName + "吃第" + baoZi + "个包子");
			baoZi++;
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread1("A");
		Thread t2 = new Thread1("B");
		t1.start();
		t2.start();
	}
}
