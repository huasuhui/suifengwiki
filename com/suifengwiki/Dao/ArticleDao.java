package com.suifengwiki.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.suifengwiki.Beans.Article;
import com.suifengwiki.Util.Conn;

public class ArticleDao {
	
	private Article article;
	private String theme;
	private String content;
	private String author;
	private String articleKindId;
	private String articleTag;
	
	private Connection conn;
	private String sql;
	private boolean flag = true;
	private String errorMessage = "";
	
	public Boolean articleSave(){
		theme = article.getTheme();
		content = article.getContent();
		author = article.getAuthor();
		articleKindId = article.getArticleKindId();
		articleTag = article.getArticleTag();
		
		sql = "insert into article(theme,content,author) values('"+ theme +"','"+ content +"','"+ author +"')";
		System.out.println(sql);
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			if(result == -1){
				flag = false;
				errorMessage += "insert语句执行失败!";
			}
		} catch (SQLException e) {
			flag = false;
			errorMessage += e.getMessage();
			e.printStackTrace();
		}

		return flag;
	}
	
	public List<Article> articleQuery(String articleId){
		List<Article> articles = new ArrayList<Article>();
		sql = "select articleId,theme,content,author,articleKindId, articleTag,modifydate from article where 1=1";
		
		if(!"all".equals(articleId)){
			sql += " and articleid = '"+ articleId +"'";
		}
		System.out.println(sql);
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			if(result != null){
				while(result.next()){
					Article article = new Article();
					article.setArticleId(result.getInt("articleId"));
					article.setTheme(result.getString("theme"));
					article.setContent(result.getString("content"));
					article.setAuthor(result.getString("author"));
					article.setArticleKindId(result.getString("articleKindId"));
					article.setArticleTag(result.getString("articleTag"));
					article.setModifydate(result.getString("modifydate"));
					articles.add(article);
				}
			}
		} catch (SQLException e) {
			flag = false;
			errorMessage += "获取文章列表异常！";
			e.printStackTrace();
		}
		
		return articles;
	}
	
	public Boolean articleUpdate(Article article){
		
		sql = "update article set theme='"+ article.getTheme() +"',content='"+ article.getContent() +"',author='"+ article.getAuthor() +"',articleKindId='"+ article.getArticleKindId() +"' where articleId = '"+ article.getArticleId() +"'";
		System.out.println(sql);
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			if(result == -1){
				flag = false;
				errorMessage += "update语句执行失败!";
			}
		} catch (SQLException e) {
			flag = false;
			errorMessage += e.getMessage();
			e.printStackTrace();
		}

		return flag;
	}
	
	public Boolean articleDelete(String articleId){
		sql = "delete from article where articleId = '"+ article.getArticleId() +"'";
		System.out.println(sql);
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			if(result == -1){
				flag = false;
				errorMessage += "delete语句执行失败!";
			}
		} catch (SQLException e) {
			flag = false;
			errorMessage += e.getMessage();
			e.printStackTrace();
		}

		return flag;
	}
	
	

	public ArticleDao(Article article) {
		this.article = article; 
		conn = Conn.getConn();
	}
	
	public ArticleDao(){
		
	}

}
