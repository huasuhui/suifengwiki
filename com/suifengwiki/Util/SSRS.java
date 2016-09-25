package com.suifengwiki.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import sun.applet.Main;

/**
 * 此工具类用作存储从数据库取出的数据
 * */
public class SSRS {
	
	private int row = 0;
	private int col = 0;
	
	private List<String> rows = new ArrayList<String>();
	private List<String> cols = new ArrayList<String>();
	
	private void addData(){
		
	}
	
	public List<List<String>> ExecSQL(String sql){
		List<List<String>> lists = new ArrayList<List<String>>();
		
		Connection conn = Conn.getConn();
		System.out.println(sql);
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			if(result != null){
				while(result.next()){
					List<String> list = new ArrayList<String>();
					for(int i=1;i<=result.getMetaData().getColumnCount();i++){
						list.add(result.getObject(i)+"");
					}
					lists.add(list);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}
	

	public SSRS() {
		
	}
	
	public static void main(String[] args) {
		SSRS ssrs = new SSRS();
		List<List<String>> lists = ssrs.ExecSQL("select theme,content,articleKindId from article order by articleKindId desc");
		System.out.println(Arrays.asList(lists));
	}

}
