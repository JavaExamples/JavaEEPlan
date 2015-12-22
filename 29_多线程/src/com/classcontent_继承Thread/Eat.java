package com.classcontent_继承Thread;

public class Eat extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println("Eat meal");
		}
	}
}
