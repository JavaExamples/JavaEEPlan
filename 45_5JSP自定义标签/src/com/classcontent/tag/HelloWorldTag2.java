package com.classcontent.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloWorldTag2 extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int doStartTag() throws JspException {
		// 获取JspWriter
		JspWriter out = this.pageContext.getOut();
		try {
			// 向页面输出
			out.println("Hello World" + "<br>" + name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return TagSupport.SKIP_BODY;// 结束标签
	}
}
