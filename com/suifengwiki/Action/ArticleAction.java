package com.suifengwiki.Action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.views.freemarker.tags.SetModel;

import com.opensymphony.xwork2.ActionSupport;

public class ArticleAction extends ActionSupport {
	
	private String content;
	
	


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public ArticleAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String save(){
		System.out.println(content);
		return "save";
	}
	
	public String edit(){
		return "edit";
	}

	
	

}
