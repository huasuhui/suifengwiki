package com.suifengwiki.Util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pubfun {
	
	/**
	 * �õ���ǰϵͳ���� author: YT
	 * 
	 * @return ��ǰ���ڵĸ�ʽ�ַ���,���ڸ�ʽΪ"yyyy-MM-dd"
	 */
	public static String getCurrentDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	/**
	 * �õ���ǰϵͳʱ�� author: YT
	 * 
	 * @return ��ǰʱ��ĸ�ʽ�ַ�����ʱ���ʽΪ"HH:mm:ss"
	 */
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
