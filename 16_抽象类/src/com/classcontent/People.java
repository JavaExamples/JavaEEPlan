package com.classcontent;

/*
 * 定义一个抽象类People
 * 
 * 抽象类:
 * 包含一个抽象方法的类是抽象类 [抽象类可以不含抽象方法]
 * 抽象类和抽象方法都要用abstract关键字声明
 * 抽象类只需要声明而不需要事先
 * 抽象类必须被子类(假如不是抽象类)必须重写抽象类中的全部抽象方法
 * 抽象类不能被实例化
 * 
 */
public abstract class People {
	// 姓名
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void say() {
		System.out.println("我的姓名是: " + this.name);
	}
	
	/*
	 * 定义一个抽象方法
	 */
	public abstract void profession();
}
