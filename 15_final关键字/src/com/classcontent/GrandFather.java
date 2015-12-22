package com.classcontent;

public class GrandFather {
	// final 修饰的方法不能被子类覆盖
	public final void noChange() {
		System.out.println("不能修改");
	}
}
