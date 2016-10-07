package com.suifengwiki.Beans;

public class Article {
	
	private int articleId;
	
	private String theme;
	
	private String content;
	
	private String author;
	
	private String articleKindId;
	
	private String articleTag;
	
	private String state;
	
	private String makedate;
	
	private String maketime;
	
	private String modifydate;
	
	private String modifytime;
	
	

	public int getArticleId() {
		return articleId;
	}



	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}



	public String getTheme() {
		return theme;
	}



	public void setTheme(String theme) {
		this.theme = theme;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public String getArticleKindId() {
		return articleKindId;
	}



	public void setArticleKindId(String articleKindId) {
		this.articleKindId = articleKindId;
	}



	public String getArticleTag() {
		return articleTag;
	}



	public void setArticleTag(String articleTag) {
		this.articleTag = articleTag;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getMakedate() {
		return makedate;
	}



	public void setMakedate(String makedate) {
		this.makedate = makedate;
	}



	public String getMaketime() {
		return maketime;
	}



	public void setMaketime(String maketime) {
		this.maketime = maketime;
	}



	public String getModifydate() {
		return modifydate;
	}



	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}



	public String getModifytime() {
		return modifytime;
	}



	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}

	

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", theme=" + theme + ", content=" + content + ", author=" + author
				+ ", articleKindId=" + articleKindId + ", articleTag=" + articleTag 
				+ ", state=" + state + ", makedate=" + makedate + ", maketime=" + maketime + ", modifydate="
				+ modifydate + ", modifytime=" + modifytime + "]";
	}

	public Article() {

	}

}
