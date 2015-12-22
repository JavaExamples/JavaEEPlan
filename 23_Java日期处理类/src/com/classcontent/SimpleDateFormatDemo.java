package com.classcontent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
	
	/**
	 *  根据style 格式化date 返回结果字符串
	 * @param date
	 * @param style
	 * @return
	 */
	public static String formatDate(Date date, String style) {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		if (date != null) {
			result = sdf.format(date);
		}
		return result;
	}
	
	/**
	 *  将日期字符串转化为一个日期对象
	 * @param dataStr 日期字符串
	 * @param style   格式
	 * @return
	 */
	public static Date formatDate(String dateStr, String style) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		return sdf.parse(dateStr);
	}
	
	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(date));
		System.out.println(SimpleDateFormatDemo.formatDate(date, "yyyy年MM月dd日 HH:mm:ss"));
		
		String dateStr = "1992-12-04";
		Date dateFromStr = formatDate(dateStr, "yyyy-MM-dd");
		System.out.println(sdf.format(dateFromStr));
	}
}
