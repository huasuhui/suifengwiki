package com.suifengwiki.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pubfun {
	

	public static String getCurrentDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	public static String getCurrentTime() {
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	
	public Pubfun() {
		
	}

}
