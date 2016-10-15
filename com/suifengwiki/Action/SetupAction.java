package com.suifengwiki.Action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.suifengwiki.Dao.SetupDao;
import com.suifengwiki.Util.ExeSQL;

public class SetupAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String webSiteTheme;
	private String webSiteEmail;
	private String webSiteDateFormat;
	private String webSiteTimeFormat;
	private String webSiteFooterSetup;
	
	public String getWebSiteTheme() {
		return webSiteTheme;
	}

	public void setWebSiteTheme(String webSiteTheme) {
		this.webSiteTheme = webSiteTheme;
	}

	public String getWebSiteEmail() {
		return webSiteEmail;
	}

	public void setWebSiteEmail(String webSiteEmail) {
		this.webSiteEmail = webSiteEmail;
	}

	public String getWebSiteDateFormat() {
		return webSiteDateFormat;
	}

	public void setWebSiteDateFormat(String webSiteDateFormat) {
		this.webSiteDateFormat = webSiteDateFormat;
	}

	public String getWebSiteTimeFormat() {
		return webSiteTimeFormat;
	}

	public void setWebSiteTimeFormat(String webSiteTimeFormat) {
		this.webSiteTimeFormat = webSiteTimeFormat;
	}

	public String getWebSiteFooterSetup() {
		return webSiteFooterSetup;
	}

	public void setWebSiteFooterSetup(String webSiteFooterSetup) {
		this.webSiteFooterSetup = webSiteFooterSetup;
	}
	
	

	@Override
	public String toString() {
		return "SetupAction [webSiteTheme=" + webSiteTheme + ", webSiteEmail=" + webSiteEmail + ", webSiteDateFormat="
				+ webSiteDateFormat + ", webSiteTimeFormat=" + webSiteTimeFormat + ", webSiteFooterSetup="
				+ webSiteFooterSetup + "]";
	}

	public SetupAction() {
		
	}
	
	public String commonSetup(){
		ExeSQL mExeSQL = new ExeSQL();
		webSiteTheme = mExeSQL.getOneValue("select code1 from ldcode a where a.codetype = 'webSiteTheme'");
		webSiteEmail = mExeSQL.getOneValue("select code1 from ldcode a where a.codetype = 'webSiteEmail'");
		webSiteDateFormat = mExeSQL.getOneValue("select code1 from ldcode a where a.codetype = 'webSiteDateFormat'");
		webSiteTimeFormat = mExeSQL.getOneValue("select code1 from ldcode a where a.codetype = 'webSiteTimeFormat'");
		webSiteFooterSetup = mExeSQL.getOneValue("select code1 from ldcode a where a.codetype = 'webSiteFooterSetup'");
		
		return "commonSetup";
	}
	
	public String websiteSetup() throws IOException{
		System.out.println(this);
		boolean flag = true;
		//将信息保存进数据库
		SetupDao mSetupDao = new SetupDao();
		if(!mSetupDao.saveSetupInfo(webSiteTheme, webSiteEmail, webSiteDateFormat, webSiteTimeFormat, webSiteFooterSetup)){
			flag = false;
		}
		//返回信息给界面
		if(!flag){
			HttpServletResponse response=ServletActionContext.getResponse();  
		    response.setContentType("text/html;charset=utf-8");  
		    PrintWriter out = response.getWriter();  
		    String jsonString="{\"msg\":\"更新站点信息失败！\"}";  
		    out.println(jsonString);  
		    out.flush();  
		    out.close(); 
		}
		
		return "websiteSetup";
	}
	

	public static void main(String[] args) {

	}

}
