package com.login.listener;
/**
 * Session 属性监听器
 */
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("添加的属性名:" + httpSessionBindingEvent.getName());
		System.out.println("添加的属性值:" + httpSessionBindingEvent.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("删除的属性名:" + httpSessionBindingEvent.getName());
		System.out.println("删除的属性值:" + httpSessionBindingEvent.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
		System.out.println("修改的属性名:" + httpSessionBindingEvent.getName());
		System.out.println("修改的属性值:" + httpSessionBindingEvent.getValue());
	}

}
