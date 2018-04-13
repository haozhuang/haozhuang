package com.haoguo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 * 
 * @author ThinkGem
 * @version 2014-4-15
 */
public class DateUtils {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static DateUtils du = null;

	public static DateUtils getInstent() {
		if (du == null)
			du = new DateUtils();
		return du;
	}

	public Date strToDate(String date) {
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String dateNowToStr() {
		return dateToStr(new Date());
	}

	public String dateToStr(Date date) {
		return sdf.format(date);
	}

}
