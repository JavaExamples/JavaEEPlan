package com.classcontent_线程同步;

public class SynchronizedDemo implements Runnable {
	private int baoZi = 10;
	
	@Override
	// synchronized 线程同步方法
	public synchronized void run() {
		while(baoZi > 0) {
			System.out.println(Thread.currentThread().getName() + "吃了第" + baoZi + "个包子");
			baoZi--;
		}
	}
	
	public static void main(String[] args) {
		SynchronizedDemo demo1 = new SynchronizedDemo();
		new Thread(demo1, "A").start();
		new Thread(demo1, "B").start();
		new Thread(demo1, "C").start();
	}
}
