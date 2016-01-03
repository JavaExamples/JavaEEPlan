package com.classcontent.tag;

import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IterateTag extends TagSupport {

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
	public int doStartTag() throws JspException {
		Object value = this.pageContext.getAttribute(items);
		if(value != null && value instanceof List) {
			this.iter = ((List)value).iterator();
			if(iter.hasNext()){
				this.pageContext.setAttribute(var, iter.next());
				return TagSupport.EVAL_BODY_INCLUDE; // 执行标签体
			} else {
				return TagSupport.SKIP_BODY; // 退出标签体
			}
		} else {
			return TagSupport.SKIP_BODY; // 退出标签体
		}
	}
	@Override
	public int doAfterBody() throws JspException {
		if(iter.hasNext()){
			this.pageContext.setAttribute(var, iter.next());
			return TagSupport.EVAL_BODY_AGAIN; // 再次执行标签体
		} else {
			return TagSupport.SKIP_BODY; // 退出标签体
		}
	}
	
	
	

}
