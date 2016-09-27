package com.suifengwiki.Action;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

public class ActionImageUpload {
	
	private String file;
	private String fileContentType;
	private String fileFileName;
	
	
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void imageUpload() throws IOException{
		System.out.println("imageUpload...");
		System.out.println(this);
		
		ServletContext servletContext = ServletActionContext.getServletContext();
		String basePath = "Files/" + fileFileName;
		String dir = servletContext.getRealPath(basePath);
		System.out.println(servletContext.getContextPath());
		System.out.println(dir);
		FileOutputStream fo = new FileOutputStream(dir);
		FileInputStream fi = new FileInputStream(file);
		
		int len;
		byte[] buf = new byte[1024];
		
		while((len=fi.read(buf))  != -1){
			fo.write(buf, 0, len);
		}
		
		fo.flush();
		fo.close();
		fi.close();

		HttpServletResponse response=ServletActionContext.getResponse();  
	    /* 
	     * 在调用getWriter之前未设置编码(既调用setContentType或者setCharacterEncoding方法设置编码), 
	     * HttpServletResponse则会返回一个用默认的编码(既ISO-8859-1)编码的PrintWriter实例。这样就会 
	     * 造成中文乱码。而且设置编码时必须在调用getWriter之前设置,不然是无效的。 
	     * */  

	    response.setContentType("text/html;charset=utf-8");  
	    //response.setCharacterEncoding("UTF-8");  
	    PrintWriter out = response.getWriter();  
	    //JSON在传递过程中是普通字符串形式传递的，这里简单拼接一个做测试  
//	    String jsonString="{\"dir\":\"123\"}";  
	    out.println(servletContext.getInitParameter("contextPath") + basePath);  
	    out.flush();  
	    out.close();  
		
		
	}

	public ActionImageUpload() {
		
	}

}
