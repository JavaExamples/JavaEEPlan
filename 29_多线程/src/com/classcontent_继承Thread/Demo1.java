package com.classcontent_继承Thread;

public class Demo1 {

	public static void main(String[] args) {
		/**
		 * 利用多线程一边听音乐一边吃饭
		 */
		
		Music music = new Music();
		Eat eat = new Eat();
		
		music.start();
		eat.start();
	}
}
