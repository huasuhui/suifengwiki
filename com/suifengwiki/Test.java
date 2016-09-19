package com.suifengwiki;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

public class Test implements RequestAware {

	public Test() {
		// TODO Auto-generated constructor stub
	}


	public String execute(){
		requestMap.put("page", "articleEdit");
		System.out.println("test...");
		return "success";
	}


	private Map<String, Object> requestMap;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;	
	}
}
