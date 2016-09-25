package com.suifengwiki.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.suifengwiki.Beans.Article;
import com.suifengwiki.Beans.ArticleKind;
import com.suifengwiki.Util.Conn;

public class KindDao {

	public KindDao() {
		
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

}
