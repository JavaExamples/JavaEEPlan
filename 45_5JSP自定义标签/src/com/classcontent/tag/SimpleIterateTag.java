package com.classcontent.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleIterateTag extends SimpleTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String var;
	private String items;
	private Iterator iter;
	public String getVar() {
		return var;
	}
	public void setVar(String var) {
		this.var = var;
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public Iterator getIter() {
		return iter;
	}
	public void setIter(Iterator iter) {
		this.iter = iter;
	}
	@Override
	public void doTag() throws JspException, IOException {
		Object value = this.getJspContext().getAttribute(items);
		if(value != null && value instanceof List) {
			Iterator iter = ((List)value).iterator();
			while(iter.hasNext()) {
				this.getJspContext().setAttribute(var, iter.next());
				this.getJspBody().invoke(null); // 响应页面
			}
		}
	}
	
	

}
