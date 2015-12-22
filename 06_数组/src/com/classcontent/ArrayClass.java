package com.classcontent;

public class ArrayClass {
	public static void main(String[] args) {
		// 定义一个数组
		int arr1[];
		// 定义一个数组
		int []arr2;
		// 定义一个数组且静态初始化
		int arr[] = new int[]{1, 2, 3};
		
		// 普通的遍历数组方式
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// for each 遍历数组
		for (int j: arr) {
			System.out.println(j);
		}
		
		// 定义一个数组, 动态初始化, 数组长度为3
		String arr3[] = new String[3];
		for (String i: arr3) {
			System.out.println(i);
		}
		
		// 二维数组的静态初始化
		int[][] newArr = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		
		for (int i = 0; i < newArr.length; i++) {
			for (int j = 0; j < newArr[i].length; j++) {
				System.out.print(newArr[i][j] + " ");
			}
			System.out.println();
		}
		
		// 二维数组的动态初始化
		int[][] newArr2 = new int[3][3];
		
		for (int i = 0; i < newArr2.length; i++) {
			for (int j = 0; j < newArr2[i].length; j++) {
				System.out.print(newArr2[i][j] + " ");
			}
			System.out.println();
		}
		
		// 排序
		int arrO[] = {4, 21, 0, -12, -3};
		int temp;
			// 循环次数n-1次
		for (int i = 0; i < arrO.length; i++) {
			// 比较次数n-1-i
			for (int j = 0; j < arrO.length - 1 - i; j++) {
				// 如果前面的数大于后面, 则交换数据
				if (arrO[j] > arrO[j+1]) {
					temp = arrO[j];
					arrO[j] = arrO[j+1];
					arrO[j+1] = temp;
				}
			}
		}
		// 显示排序结果
		for (int i: arrO) {
			System.out.print(i  + " ");
		}
	}
}
