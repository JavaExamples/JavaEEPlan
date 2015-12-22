package com.classcontent_线程同步;

public class SynchronizedBlockDemo implements Runnable {
private int baoZi = 10;
	
	@Override
	public void run() {
		// synchronized同步块
		synchronized (this) {
			while(baoZi > 0) {
				System.out.println(Thread.currentThread().getName() + "吃了第" + baoZi + "个包子");
				baoZi--;
			}
		}
	}
	
	public static void main(String[] args) {
		SynchronizedBlockDemo demo1 = new SynchronizedBlockDemo();
		Thread t1 = new Thread(demo1, "A");
		Thread t2 = new Thread(demo1, "B");
		Thread t3 = new Thread(demo1, "C");
		
		t1.start();
		t2.start();
		t3.start();
	}
}
