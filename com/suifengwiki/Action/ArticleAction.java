package com.suifengwiki.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.suifengwiki.Beans.Article;
import com.suifengwiki.Dao.ArticleDao;
import com.suifengwiki.Dao.KindDao;
import com.suifengwiki.Util.SSRS;

public class ArticleAction extends ActionSupport implements ModelDriven<Article>,RequestAware {

	private static final long serialVersionUID = 1L;
	
	private ArticleDao articleDao;
	

	public ArticleAction() {
	}
	
	
	public String save(){
		System.out.println(article);
		articleDao = new ArticleDao(article);
		articleDao.articleSave();

		setArticlesAndKinds();
		
		return "save";
	}
	
	public String draftSave() throws IOException{
		System.out.println(article);
		articleDao = new ArticleDao(article);
		articleDao.articleSave();
		
		SSRS ssrs = new SSRS();
		String articleId = ssrs.getOneValue("select articleId from article where theme = '"+ article.getTheme() +"'");
		
		HttpServletResponse response=ServletActionContext.getResponse();  
	    response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter();  
	    out.println(articleId);  
	    out.flush();  
	    out.close(); 
		
		return "draftSave";
	}
	
	public String query(){
		

		return "query";
	}
	
	public String edit(){
		System.out.println(article);
		articleDao = new ArticleDao(article);
		List<Article> articleResult = articleDao.articleQuery(article.getArticleId()+"");
		if(articleResult != null && articleResult.size()>0){
			requestMap.put("articleResult", articleResult.get(0));
		}
		
		SSRS ssrs = new SSRS();
		List<List<String>> kindList = ssrs.ExecSQL("select articleKindId,articleKindName from articlekind order by articleKindId");
		requestMap.put("kindList", kindList);
		System.out.println(Arrays.asList(kindList));
		
		KindDao kindDao = new KindDao(null);
		Map<String,String> kindMap =  kindDao.getKindMap();
		requestMap.put("kindMap", kindMap);
		
		
		return "edit";
	}
	
	public String list(){
		articleDao = new ArticleDao(article);
		List<Article> articles = articleDao.articleQuery("publish");
		requestMap.put("articles", articles);
		
		KindDao kindDao = new KindDao(null);
		Map<String,String> kindMap =  kindDao.getKindMap();
		requestMap.put("kindMap", kindMap);
		requestMap.put("state", "0");
		
		return "list";
	}
	
	/**
	 * 后台搜索指定文章
	 * */
	public String adminListSearch(){
		articleDao = new ArticleDao(article);
		List<Article> articles = articleDao.articleQuerySpec(article.getState());
		requestMap.put("articles", articles);
		
		KindDao kindDao = new KindDao(null);
		Map<String,String> kindMap =  kindDao.getKindMap();
		requestMap.put("kindMap", kindMap);
		requestMap.put("state", article.getState());
		
		return "adminListSearch";
	}
	
	/**
	 * 前台搜索指定文章
	 * */
	public String listSearch(){
		
		List<Map<String,List<Article>>> kindArticleMaps = new ArrayList<Map<String,List<Article>>>();
		
		SSRS ssrs = new SSRS();
		String sql = "select articleKindId,articleId,theme from article where state = '0' and (theme like '%"+ article.getTheme() +"%' "
				+ " or content like '%"+ article.getTheme() +"%' "
				+ " or articleTag like '%"+ article.getTheme() +"%' )";
		List<List<String>> kindArticleList = ssrs.ExecSQL(sql);
		List<List<String>> kindList = ssrs.ExecSQL("select articleKindId,articleKindName from articlekind order by articleKindId");
		
		for(int x=0;x<kindList.size();x++){
			List<Article> list = new ArrayList<Article>();
			for(int y=0;y<kindArticleList.size();y++){
				if(kindList.get(x).get(0).equals(kindArticleList.get(y).get(0))){
					Article article = new Article();
					article.setArticleId(Integer.parseInt(kindArticleList.get(y).get(1)));
					article.setTheme(kindArticleList.get(y).get(2));
					list.add(article);
				}
			}
			if(list != null && list.size()>0){
				Map<String,List<Article>> map = new HashMap<String,List<Article>>();
				map.put(kindList.get(x).get(1), list);
				kindArticleMaps.add(map);
			}
		}
		
		requestMap.put("kindArticleMaps", kindArticleMaps);
		
		return "listSearch";
	}
	
	public String delete(){
		//删除指定的文章
		articleDao = new ArticleDao(article);
		if(!articleDao.articleDelete()){
			System.out.println("删除失败！");
		}
		
		setArticlesAndKinds();
		
		return "delete";
	}
	
	public String stateUpdate(){
		articleDao = new ArticleDao(article);
		if(!articleDao.articleStateUpdate()){
			System.out.println("修改文章状态失败！");
		}
		setArticlesAndKinds();
		
		return "stateUpdate";
	}
	
	
	/**
	 * 为requestMap获取所有articles和kinds
	 * */
	private void setArticlesAndKinds(){
		articleDao = new ArticleDao(article);
		List<Article> articles = articleDao.articleQuery("publish");
		
		if("0".equals(article.getState())){
			articles = articleDao.articleQuery("publish");
		}else{
			articles = articleDao.articleQuery("draft");
		}
		
		requestMap.put("articles", articles);
		
		KindDao kindDao = new KindDao(null);
		Map<String,String> kindMap =  kindDao.getKindMap();
		requestMap.put("kindMap", kindMap);
	}
	
	public String draft(){
		articleDao = new ArticleDao(article);
		List<Article> articles = articleDao.articleQuery("draft");
		requestMap.put("articles", articles);
		
		KindDao kindDao = new KindDao(null);
		Map<String,String> kindMap =  kindDao.getKindMap();
		requestMap.put("kindMap", kindMap);
		requestMap.put("state", "1");
		return "draft";
	}
	
	public String index(){
		List<Map<String,List<Article>>> kindArticleMaps = new ArrayList<Map<String,List<Article>>>();
		
		SSRS ssrs = new SSRS();
		List<List<String>> kindArticleList = ssrs.ExecSQL("select articleKindId,articleId,theme from article where state = '0' order by articleKindId desc");
		List<List<String>> kindList = ssrs.ExecSQL("select articleKindId,articleKindName from articlekind order by articleKindId");
		
		for(int x=0;x<kindList.size();x++){
			List<Article> list = new ArrayList<Article>();
			for(int y=0;y<kindArticleList.size();y++){
				if(kindList.get(x).get(0).equals(kindArticleList.get(y).get(0))){
					Article article = new Article();
					article.setArticleId(Integer.parseInt(kindArticleList.get(y).get(1)));
					article.setTheme(kindArticleList.get(y).get(2));
					list.add(article);
				}
			}
			if(list != null && list.size()>0){
				Map<String,List<Article>> map = new HashMap<String,List<Article>>();
				map.put(kindList.get(x).get(1), list);
				kindArticleMaps.add(map);
			}
		}
		
		requestMap.put("kindArticleMaps", kindArticleMaps);
		return "index";
	}
	
	public String detail(){
		
		System.out.println(article);
		articleDao = new ArticleDao(article);
		List<Article> articleResult = articleDao.articleQuery(article.getArticleId()+"");
		if(articleResult != null && articleResult.size()>0){
			requestMap.put("articleResult", articleResult.get(0));
		}
		return "detail";
	}
	
	public String predetail() throws UnsupportedEncodingException{
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setCharacterEncoding("UTF-8");
		
		String ss=new String(article.getTheme().getBytes("ISO-8859-1"),"utf-8");
		System.out.println(ss);
		System.out.println(article);
		requestMap.put("articleResult", article);
		return "predetail";
	}
	
	public void getArticle_draft_count() throws IOException{
		
		SSRS ssrs = new SSRS();
		String articleId = ssrs.getOneValue("select count(1) from article where state = 1");
		HttpServletResponse response=ServletActionContext.getResponse();  
	    response.setContentType("text/html;charset=utf-8");  
	    PrintWriter out = response.getWriter();  
	    out.println(articleId);  
	    out.flush();  
	    out.close(); 
	}
	
	private Article article = new Article();

	public Article getModel(){ 
		article.setAuthor("suifeng");
		return article;
	}

	private Map<String, Object> requestMap;
	
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	} 
	
	
}
