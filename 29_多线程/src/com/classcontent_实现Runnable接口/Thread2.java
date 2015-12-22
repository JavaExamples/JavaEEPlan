package com.classcontent_实现Runnable接口;

public class Thread2 implements Runnable {
	private int baoZi = 1;
	private String threadName;
	
	public Thread2(String threadName) {
		super();
		this.threadName = threadName;
	}
	
	@Override
	public synchronized void run() { // 线程同步 [只能一个线程进入这个方法]
		while (baoZi <= 10) {
			System.out.println(threadName + "吃第" + baoZi + "个包子");
			baoZi++;
		}
	}
	
	public static void main(String[] args) {
		Thread2 t21 = new Thread2("A");
		Thread2 t22 = new Thread2("B");
		
		Thread t1 = new Thread(t21);
		Thread t2 = new Thread(t22);
		Thread t3 = new Thread(t22);
		
		t1.start();
		t2.start();
		t3.start();
	}

}
