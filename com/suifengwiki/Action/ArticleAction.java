package com.suifengwiki.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.suifengwiki.Beans.Article;

public class ArticleAction extends ActionSupport implements ModelDriven<Article> {

	private static final long serialVersionUID = 1L;
	

	public ArticleAction() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String save(){
		System.out.println(article);

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
