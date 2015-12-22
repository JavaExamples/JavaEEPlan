package com.classcontent;

public class Demo {
	public static void main(String[] args) {
		String str = "123a";
		try {
			int a = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("数字格式异常");
			e.printStackTrace();
			return; // 若执行了return, 则end不会被输出
		} catch (NullPointerException e) {
			System.out.println("空指针异常");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("异常");
			e.printStackTrace();
		} finally {
			System.out.println("就算你在前面return 我也会执行");
		}
		System.out.println("end");
	}
}
