package com.suifengwiki.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.suifengwiki.Beans.Article;
import com.suifengwiki.Dao.ArticleDao;

public class ArticleAction extends ActionSupport implements ModelDriven<Article> {

	private static final long serialVersionUID = 1L;
	
	private ArticleDao articleDao;
	

	public ArticleAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String save(){
		System.out.println(article);
		articleDao = new ArticleDao(article);
		articleDao.articleSave();

		return "save";
	}
	
	public String edit(){
		return "edit";
	}
	
	private Article article = new Article();

	public Article getModel(){ 
		return article;
	} 
	

}
