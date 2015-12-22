package com.classcontent;

public class People {
	// 最简单的方法定义
	void speak() {
		System.out.println("I'm speaking");
	}

	// 带参数的方法定义 & 方法的重载[名称相同, 参数类型或者数量不同]
	void speak(String name) {
		System.out.println("我叫" + name);
	}
	
	void speak(String name, int age) {
		System.out.println("我叫" + name + ", 我今年" + age + "岁");
	}
	
	// 入参
	int speak(String name, int age, String ...hobbies) {
		System.out.println("我叫" + name);
		System.out.print("我的爱好有:");
		for (String hobby: hobbies) {
			System.out.print(hobby + " ");
		}
		// 获取爱好的长度
		int totalHobbies = hobbies.length;
		return totalHobbies;
	}
	
	// 普通方法
	void func1() {
		System.out.println("这是普通方法");
	}

	// 静态方法
	static void func2() {
		System.out.println("这是静态方法");
	}
	
	// 递归和非递归 求1*2*3***n
		// 非递归
	static long notDiGui(int n) {
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
		// 递归
	static long diGui(int n) {
		if (n == 1) {
			return 1;
		}
		return diGui(n-1) * n;
	}
	
	public static void main(String[] args) {
		People p = new People();
		p.speak();
		p.speak("Guibs");
		p.speak("Rio_G", 22);
		int n = p.speak("Joker", 23, "tell joke", "code", "Swift");
		System.out.println("名为Joker的人 有 " + n + " 个爱好");
		
		// 调用普通方法
		p.func1();
		
		// 调用静态方法
		p.func2();
		People.func2();
		
		long notDiGui = People.notDiGui(3);
		System.out.println(notDiGui);
		
		long diGui = People.diGui(3);
		System.out.println(diGui);
	}
	
	// 注意传入函数的参数是值类型还是引用类型
}
