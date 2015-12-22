package com.classcontent;

public class TestCustomException {
	public static void test() throws CustomException {
		throw new CustomException("自定义异常");
	}
	
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
