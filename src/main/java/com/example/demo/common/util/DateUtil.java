package com.example.demo.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class DateUtil {
	
	
	/**
	 * 数据库存储的默认时间格式
	 */
	public static final String DEFAULT_TIME_FORMAT_DB = "yyyyMMddHHmmss";
	/**
	 * 默认时间格式
	 */
	public static final String DEFAULT_TIME_FORMAT_DB_EN = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 默认时间格式(中文)
	 */
	public static final String DEFAULT_TIME_FORMAT_CN = "yyyy年MM月dd日 HH:mm:ss";
	/**
	 * 默认日期格式(EN)
	 */
	public static final String DEFAULT_DATE_FORMAT_EN = "yyyy-MM-dd";
	/**
	 * 默认日期格式(中文)
	 */
	public static final String DEFAULT_DATE_FORMAT_CN = "yyyy年MM月dd日";
	/**
	 * 默认日期格式
	 */
	public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";
	/**
	 * 默认年月格式
	 */
	public static final String DEFAULT_DATE_FORMAT_SHORT = "yyyyMM";
	/**
	 * 默认时间格式
	 */
	public static final String DEFAULT_TIME_FORMAT = "HHmmss";
	/**
	 * 默认时间格式
	 */
	public static final String DEFAULT_TIME_FORMAT_DB_INPUT = "yyyy/MM/dd HH:mm:ss";
	/**
	 * 默认时间格式
	 */
	public static final String DEFAULT_TIME_FORMAT_DB_OUTINPUT = "yyyy/MM/dd HH:mm";
	/**
	 * 默认时间格式
	 */
	public static final String DEFAULT_TIME_FORMAT_YYYY_MM_DD_E = "yyyy-MM-dd E";
    
	/**
	 * 获取系统当前时间
	 * 
	 * @param dataValue
	 * @param returnValue
	 * @return String
	 */
	public static String getCurrentTime(String timeFormat )
	{
		String format = (timeFormat == null) ? DEFAULT_TIME_FORMAT_DB : timeFormat;
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat( format );
		return formatter.format( date );
	}
	
}
