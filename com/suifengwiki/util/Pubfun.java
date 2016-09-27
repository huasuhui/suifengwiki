package com.suifengwiki.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pubfun {
	

	public static String getCurrentDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}


	public static String getCurrentTime() {
		String pattern = "HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	public Pubfun() {
		
	}

}
