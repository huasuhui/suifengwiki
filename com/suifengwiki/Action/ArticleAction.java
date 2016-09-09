package com.suifengwiki.Action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

public class ArticleAction implements RequestAware {

	public ArticleAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String edit(){
		requestMap.put("page", "articleEdit");
		return "edit";
	}

	private Map<String, Object> requestMap;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}

}
