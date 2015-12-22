package com.classcontent_常用方法;

public class Demo1 implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			// 让线程1s休眠一次
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 获取当前线程
			Thread t = Thread.currentThread();
			
			// 线程礼让
			if (i == 9 && t.getName().equals("线程1")) {
				System.out.println("线程礼让");
				t.yield();
			}
			
			// 设置线程中断状态[并不能真正中断线程]
			if (i == 3 && t.getName().equals("线程2")) {
				System.out.println("线程中断");
				t.interrupt();
			}
			
			// 返回线程名称
			System.out.println(t.getName() + ":" + i);
		}
	}
	
	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		Thread t1 = new Thread(demo1, "线程1");
		Thread t2 = new Thread(demo1, "线程2");
		Thread t3 = new Thread(demo1, "线程3");
		
		// 设置线程优先级
		t1.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.NORM_PRIORITY);
		
		// 线程是否处于活动状态
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		System.out.println(t3.isAlive());
		
		t1.start();
		t2.start();
		try {
			// 等待t1执行3s后再执行join后的代码(若不设置参数, 则等待t1执行完毕后)
			t1.join(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t3.start();
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		System.out.println(t3.isAlive());
	}
}
