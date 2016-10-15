package com.suifengwiki.Dao;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;
import com.suifengwiki.Util.Conn;
import com.suifengwiki.Util.ExeSQL;

public class SetupDao{
	
	private Connection conn = Conn.getConn();
	private ExeSQL mExeSQL = new ExeSQL();

	public SetupDao() {
		// TODO Auto-generated constructor stub
	}
	
	private boolean updateWebInfo(String codetype, String value){
		String sql = "update ldcode a set a.code1 = '"+ value +"' where a.codetype = '"+ codetype +"'";
		if(!mExeSQL.execSQL(sql)){
			System.out.println("更新站点标题失败");
			return false;
		}
		return true;
	}
	
	public boolean saveSetupInfo(String webSiteTheme,String webSiteEmail,String webSiteDateFormat,
			String webSiteTimeFormat,String webSiteFooterSetup){
		boolean flag = true;
		
		if(webSiteTheme != null && !"".equals(webSiteTheme)){
			if(!updateWebInfo("webSiteTheme",webSiteTheme)){
				System.out.println("更新站点标题失败");
				flag = false;
			}
		}
		if(webSiteEmail != null && !"".equals(webSiteEmail)){
			if(!updateWebInfo("webSiteEmail",webSiteEmail)){
				System.out.println("更新站点Email失败");
				flag = false;
			}
		}
		if(webSiteDateFormat != null && !"".equals(webSiteDateFormat)){
			if(!updateWebInfo("webSiteDateFormat",webSiteDateFormat)){
				System.out.println("更新站点日期格式失败");
				flag = false;
			}
		}
		if(webSiteTimeFormat != null && !"".equals(webSiteTimeFormat)){
			if(!updateWebInfo("webSiteTimeFormat",webSiteTimeFormat)){
				System.out.println("更新站点时间格式失败");
				flag = false;
			}
		}
		if(webSiteFooterSetup != null && !"".equals(webSiteFooterSetup)){
			if(!updateWebInfo("webSiteFooterSetup",webSiteFooterSetup)){
				System.out.println("更新站点页尾设置失败");
				flag = false;
			}
		}
		return flag;
	}

}
