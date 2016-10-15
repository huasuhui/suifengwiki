package com.suifengwiki.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ExeSQL {
	
	private Connection conn;
	
	public boolean execSQL(String sql){
		String sqlUpper = sql.trim().toUpperCase();
		if(sqlUpper.startsWith("INSERT") || sqlUpper.startsWith("UPDATE") || sqlUpper.startsWith("DELETE")){
			return executeUpdate(sql);
		}else{
			System.out.println("sql不是INSERT、UPDATE、DELETE！");
		}
		return true;
	}
	
	public List<List<String>> query(String sql){
		List<List<String>> lists = new ArrayList<List<String>>();
		System.out.println(sql);
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			if (result != null) {
				while (result.next()) {
					List<String> list = new ArrayList<String>();
					for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
						list.add(result.getObject(i) + "");
					}
					lists.add(list);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return lists;
	}
	
	private boolean executeUpdate(String sql){
		System.out.println(sql);
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			int result = ps.executeUpdate();
			if(result == -1){
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String getOneValue(String sql){
		List<List<String>> list = query(sql);
		if(list.size()>0 && list.get(0).size()>0){
			return list.get(0).get(0);
		}
		return "";
	}

	public ExeSQL() {
		conn = Conn.getConn();
	}

	public static void main(String[] args) {

	}

}
