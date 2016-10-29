package com.suifengwiki.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.suifengwiki.Beans.Article;
import com.suifengwiki.Util.Conn;
import com.suifengwiki.Util.Pubfun;

public class ArticleDao {
	
	private Article article;
	private String theme;
	private String content;
	private String author;
	private String articleKindId;
	private String articleTag;
	private String state;
	
	private Connection conn;
	private String sql;
	private boolean flag = true;
	private String errorMessage = "";
	
	public Boolean articleSave(){
		
		//如果存在，先删除，再插入
		if(article != null && !"0".equals(article.getArticleId()+"")){
			articleUpdate(article);
		}else{
			theme = article.getTheme();
			content = article.getContent();
			author = article.getAuthor();
			articleKindId = article.getArticleKindId();
			articleTag = article.getArticleTag();
			state = article.getState();
			String currentdate = Pubfun.getCurrentDate();
			String currenttime = Pubfun.getCurrentTime();
			sql = "insert into article(theme,content,author,articleKindId,articleTag,state,makedate,maketime,modifydate,modifytime) "
					+ "values('"+ theme +"','"+ content +"','"+ author +"','"+ articleKindId +"','"+ articleTag +"','"+state+"','"+ currentdate +"','"+ currenttime +"','"+ currentdate +"','"+ currenttime +"')";
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
			
		}
		
		return flag;
	}
	
	public List<Article> articleQuery(String articleId){
		List<Article> articles = new ArrayList<Article>();
		sql = "select articleId,theme,content,author,articleKindId, articleTag,modifydate,modifytime,state from article where 1=1";
		
		if("publish".equals(articleId)){
			sql += " and state = '0'";
		}else if("draft".equals(articleId)){
			sql += " and state = '1'";
		}else{
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
					article.setModifytime(result.getString("modifytime"));
					article.setState(result.getString("state"));
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
	
	public List<Article> articleQuerySpec(String state){
		List<Article> articles = new ArrayList<Article>();
		sql = "select articleId,theme,content,author,articleKindId, articleTag,modifydate,state from article where state = '"+ state +"' and (theme like '%"+ article.getTheme() +"%' "
				+ " or content like '%"+ article.getTheme() +"%' "
				+ " or articleTag like '%"+ article.getTheme() +"%' )";
		
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
					article.setState(result.getString("state"));
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
		
		sql = "update article set theme='"+ article.getTheme() +"',content='"+ article.getContent() +"',author='"+ article.getAuthor() +"',articleKindId='"+ article.getArticleKindId() +"',articleTag = '"+ article.getArticleTag() +"',state='"+ article.getState() +"' where articleId = '"+ article.getArticleId() +"'";
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
	
	public Boolean articleDelete(){
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
	
	//文章状态更新
	public Boolean articleStateUpdate(){
		String state = "0".equals(article.getState()) ? "1" : "0";
		sql = "update article set state= '"+ state +"' where articleId = '"+ article.getArticleId() +"'";
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
	
	

	public ArticleDao(Article article) {
		this.article = article; 
		conn = Conn.getConn();
	}
	
	public ArticleDao(){
		
	}

}
