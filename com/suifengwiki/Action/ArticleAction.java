package com.suifengwiki.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.suifengwiki.Beans.Article;
import com.suifengwiki.Dao.ArticleDao;

public class ArticleAction extends ActionSupport implements ModelDriven<Article> {

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
		System.out.println(article);
		articleDao = new ArticleDao(article);
		articleDao.articleSave();

		return "save";
	}
	
	public String edit(){
		return "edit";
	}
	
	public String list(){
		return "list";
	}
	
	public String draft(){
		return "draft";
	}
	
	private Article article = new Article();

	public Article getModel(){ 
		return article;
	} 
	

}
