package com.classcontent;

public class Single2 {
	/**
	 * 构造方法私有
	 */
	private Single2() {
		
	}
	
	/**
	 * 懒汉式单例实现
	 */
	private static Single2 single2;
	
	/**
	 * 工厂
	 */
	public synchronized static Single2 getSingle2() { // 线程同步
		if (single2 == null) { //初次调用时实例化
			System.out.println("首次创建初始化single2");
			single2 = new Single2();
		}
		return single2;
	}
}
