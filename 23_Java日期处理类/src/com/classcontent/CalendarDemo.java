package com.classcontent;

import java.util.Calendar;

public class CalendarDemo {
	public static void main(String[] args) {
		// 实例化一个Calendar对象
		Calendar calendar = Calendar.getInstance();
		// 获取年
		System.out.println(calendar.get(Calendar.YEAR));
		// 获取月 [从0开始]
		System.out.println(calendar.get(Calendar.MONTH) + 1);
		// 输出当前时间
		System.out.println("现在是: " + calendar.get(Calendar.YEAR) + "年" 
		+ (calendar.get(Calendar.MONTH) + 1) + "月"
		+ calendar.get(Calendar.DAY_OF_MONTH) + "日"
		+ calendar.get(Calendar.HOUR_OF_DAY) + ":"
		+ calendar.get(Calendar.MINUTE) + ":"
		+ calendar.get(Calendar.SECOND));
		int week = calendar.get(Calendar.DAY_OF_WEEK);
		switch (week) {
		case 1:
			System.out.println("星期天");
			break;
		case 2:
			System.out.println("星期一");
			break;
		case 3:
			System.out.println("星期二");
			break;
		case 4:
			System.out.println("星期三");
			break;
		case 5:
			System.out.println("星期四");
			break;
		case 6:
			System.out.println("星期五");
			break;
		case 7:
			System.out.println("星期六");
			break;
		default:
			System.out.println("别闹了");
		}
	}
}
