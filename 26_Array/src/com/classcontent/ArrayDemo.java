package com.classcontent;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayDemo {
	public static void main(String[] args) {
		int arr[] = {1, 7, 3, 6, 0};
		// 以字符串形式输出数组
		System.out.println("以字符串形式输出数组: " + Arrays.toString(arr));
		// 对指定类型数组按升序排序
		Arrays.sort(arr);
		System.out.println("排序后的数组: " + Arrays.toString(arr));
		// 用二分法来搜索指定类型数组, 获得指定的值 
			// [如果它包含在数组中，则返回搜索键的索引；否则返回 (-(插入点) - 1)]
		int result = Arrays.binarySearch(arr,5);
		System.out.println(result);
		// 重置数组元素为指定元素
		Arrays.fill(arr, 1);
		System.out.println("充值后的数组的字符串化输出: " + Arrays.toString(arr));
	}
}
