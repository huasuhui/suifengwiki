package com.suifengwiki.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.suifengwiki.Beans.ArticleKind;
import com.suifengwiki.Dao.KindDao;
import com.suifengwiki.Util.SSRS;

public class KindAction extends ActionSupport implements RequestAware,ModelDriven<ArticleKind> {
	
	private static final long serialVersionUID = 1L;

	public String kindList(){
		setMapkindList();
		return "kindList";
	}
	
	public String addKind(){
		KindDao mKindDao = new KindDao(articleKind);
		if(!mKindDao.addKind()){
			System.out.println("增加kind失败！");
		}
		
		setMapkindList();
		return "addKind";
	}
	
	public String updateKind(){
		KindDao mKindDao = new KindDao(articleKind);
		if(!mKindDao.updateKind()){
			System.out.println("增加kind失败！");
		}
		
		setMapkindList();
		return "updateKind";
	}
	
	public String deleteKind() throws IOException{
		
		//删除之前判断此分类下是否含有文章，若有文章，则不允许删除
		SSRS ssrs = new SSRS();
		List<List<String>> kindArticleList = ssrs.ExecSQL("select 1 from article where articlekindid = '"+ articleKind.getArticleKindId() +"'");
		if(kindArticleList.size() > 0){
			ServletContext servletContext = ServletActionContext.getServletContext();
			HttpServletResponse response=ServletActionContext.getResponse();  

		    response.setContentType("text/html;charset=utf-8");  
		    //response.setCharacterEncoding("UTF-8");  
		    PrintWriter out = response.getWriter();  

		    String jsonString="{\"msg\":\"此分类有文章存在，不允许删除！\"}";  
		    out.println(jsonString);  
		    out.flush();  
		    out.close(); 
		}else{
			KindDao mKindDao = new KindDao(articleKind);
			if(!mKindDao.deleteKind()){
				System.out.println("删除kind失败！");
			}
		}
		setMapkindList();
		return "deleteKind";
	}
	
	private void setMapkindList(){
		KindDao mKindDao = new KindDao(articleKind);
		List<ArticleKind> kindList = mKindDao.getKindList();
		requestMap.put("kindList", kindList);
	}

	private ArticleKind articleKind = new ArticleKind();

	public ArticleKind getModel(){ 
		return articleKind;
	}
	

	public KindAction() {
	}

	private Map<String, Object> requestMap;
	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}

}
