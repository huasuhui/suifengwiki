package com.suifengwiki.Dao;

import java.sql.SQLException;
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
	private List<String> articleTag;
	
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
		
		sql = "insert into article(theme,content,author) values("+ theme +","+ content +","+ author +",)";
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
	
	

	public ArticleDao(Article article) {
		this.article = article; 
		conn = Conn.getConn();
	}
	
	public ArticleDao(){
		
	}

}
