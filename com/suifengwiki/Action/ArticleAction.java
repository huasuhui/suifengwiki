package com.suifengwiki.Action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

		return "save";
	}
	
	public String query(){
		

		return "query";
	}
	
	public String edit(){
		return "edit";
	}
	
	
	
	public String list(){
		articleDao = new ArticleDao(article);
		List<Article> articles = articleDao.articleQuery("all");
		requestMap.put("articles", articles);
		
		KindDao kindDao = new KindDao();
		Map<String,String> kindMap =  kindDao.getKindMap();
		requestMap.put("kindMap", kindMap);
		
		return "list";
	}
	
	public String draft(){
		return "draft";
	}
	
	public String index(){
		List<Map<String,List<Article>>> kindArticleMaps = new ArrayList<Map<String,List<Article>>>();
		
		SSRS ssrs = new SSRS();
		List<List<String>> kindArticleList = ssrs.ExecSQL("select articleKindId,articleId,theme from article order by articleKindId desc");
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
