package com.suifengwiki.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.suifengwiki.Beans.ArticleKind;
import com.suifengwiki.Util.Conn;
import com.suifengwiki.Util.Pubfun;
import com.suifengwiki.Util.SSRS;

public class KindDao {
	
	private ArticleKind articleKind = null;
	private Connection conn;
	private String currentdate = Pubfun.getCurrentDate();
	private String currenttime = Pubfun.getCurrentTime();
	
	public KindDao(ArticleKind articleKind) {
		this.articleKind = articleKind; 
		conn = Conn.getConn();
	}
	
	public Map<String,String> getKindMap(){
		
		Map<String,String> map = new HashMap<String,String>();
		
		Connection conn = Conn.getConn();
		String sql = "select articleKindId,articleKindName from articlekind";
		System.out.println(sql);
		
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			if(result != null){
				while(result.next()){
					map.put(result.getInt("articleKindId")+"", result.getString("articleKindName"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return map;
	}
	
	public List<ArticleKind> getKindList(){
		SSRS ssrs = new SSRS();
		List<List<String>> kinds = ssrs.ExecSQL("select articleKindId,articleKindName,modifydate from articleKind order by articleKindId");
		List<ArticleKind> kindList = new ArrayList<ArticleKind>();
		for(List<String> kind : kinds){
			ArticleKind mActicleKind = new ArticleKind();
			mActicleKind.setArticleKindId(Integer.parseInt(kind.get(0)));
			mActicleKind.setArticleKindName(kind.get(1));
			mActicleKind.setModifydate(kind.get(2));
			kindList.add(mActicleKind);
		}
		
		return kindList;
	}

	public boolean addKind() {
		String sql = "insert into articleKind(articleKindName,makedate,maketime,modifydate,modifytime) "
				+ "values('"+ articleKind.getArticleKindName() +"','"+ currentdate +"','"+ currenttime +"','"+ currentdate +"','"+ currenttime +"')";
		System.out.println(sql);
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			if(result == -1){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean updateKind() {
		String sql = "update articleKind set articleKindName = '"+ articleKind.getArticleKindName() +"',modifydate='"+ currentdate +"',modifytime='"+ currenttime +"' where articleKindId = '"+ articleKind.getArticleKindId() +"'";
		System.out.println(sql);
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			if(result == -1){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean deleteKind() {
		String sql = "delete from articleKind where articleKindId = '"+ articleKind.getArticleKindId() +"'";
		System.out.println(sql);
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			if(result == -1){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
