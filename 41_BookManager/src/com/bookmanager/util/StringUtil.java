package com.bookmanager.util;

/**
 * 字符串工具类
 * @author guibs
 *
 */
public class StringUtil {
	
	/**
	 * 判断字符串为是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 判断字符串是否不为空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null || "".equals(str.trim().isEmpty())) {
			return true;
		} else {
			return false;
		}
	}
}
