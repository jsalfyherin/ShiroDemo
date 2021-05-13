package com.example.demo.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class NumberUtil {

	/**##,###**/
	public static final String MONEY_PATTERN="##,###";
	
	/**##,###.##**/
	public static final String MONEY_PATTERN_SIMPLE="##,###.00";
	
	/**
	 * 将对象转换为Long类型返回，如果没有记录则返回0
	 * @param obj
	 * @return
	 */
	public static long getLongFromObject(Object obj) {
		long oid = 0;
		if (obj == null) {
			return oid;
		}
		if (obj instanceof Number) {
			oid = ((Number) obj).longValue();
		}
		return oid;
	}
	
	public static int getTotalPage(int totalNo,int pageSize) {
		int totalPage = totalNo / pageSize;
		if (totalNo % pageSize != 0) {
			totalPage += 1;
		}
		return totalPage;
	}
	
	/**
	 * 
	 * @Title: bytesToHexString 
	 * @Description: TODO(把字节数组转换成16进制字符串) 
	 * @param bArray 字节数组
	 * @return String
	 * @throws
	 */
	public static final String bytesToHexString(byte[] bArray) {
	    StringBuffer sb = new StringBuffer(bArray.length);
	    String sTemp;
	    for (int i = 0; i < bArray.length; i++) {
	      sTemp = Integer.toHexString(0xFF & bArray[i]);
	      if (sTemp.length() < 2){
	        sb.append(0);
	      }
	      sb.append(sTemp.toUpperCase());
	    }
	    return sb.toString();
	}
	
	private static BigDecimal getDecimal(String literal) {
		if (literal == null || literal.length() == 0) {
			return new BigDecimal("0");// 改成"0"，为了兼容Java 1.4
		}
		if (literal.charAt(0) == '.') {
			return new BigDecimal("0" + literal);
		}
		return new BigDecimal(literal);
	}
	
	// 加法运算
	public static String addBigDecimal(String decimalLiteral1,
			String decimalLiteral2) {
		decimalLiteral1 = decimalLiteral1.replaceAll(",", "");
		decimalLiteral2 = decimalLiteral2.replaceAll(",", "");
		return getDecimal(decimalLiteral1).add(getDecimal(decimalLiteral2)).toString();
	}
	
	// 减法运算
	public static String subBigDecimal(String decimalLiteral1,
			String decimalLiteral2) {
		decimalLiteral1 = decimalLiteral1.replaceAll(",", "");
		decimalLiteral2 = decimalLiteral2.replaceAll(",", "");
		return getDecimal(decimalLiteral1).subtract(getDecimal(decimalLiteral2)).toString();
	}
	
	// 乘法运算
	public static String mulBigDecimal(String decimalLiteral1,
			String decimalLiteral2) {
		decimalLiteral1 = decimalLiteral1.replaceAll(",", "");
		decimalLiteral2 = decimalLiteral2.replaceAll(",", "");
		return getDecimal(decimalLiteral1).multiply(getDecimal(decimalLiteral2)).toString();
	}
	
	// 除法运算  num 小数点位数
	public static String divBigDecimal(String decimalLiteral1,
			String decimalLiteral2,int num) {
		decimalLiteral1 = decimalLiteral1.replaceAll(",", "");
		decimalLiteral2 = decimalLiteral2.replaceAll(",", "");
		return getDecimal(decimalLiteral1).divide(getDecimal(decimalLiteral2),num, BigDecimal.ROUND_HALF_UP).toString();
	}
	
	/**
	 * 判断是都全部为数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){ 
		if(StringUtil.isEmpty(str)) {
			return false ;
		}
		Pattern pattern = Pattern.compile("[0-9]*"); 
		return pattern.matcher(str).matches(); 
	 } 
	
	/**
	 * 
	 * <DL>
	 * <DT><B> 字符串的比较 </B></DT>
	 * <p>
	 * <DD> 详细介绍:字符串的比较 .</DD>
	 * </DL>
	 * <p>
	 * 
	 * @param decimalLiteral1
	 *            字符串一
	 * @param decimalLiteral2
	 *            字符串二
	 * @return 比较两个数字的大小，相等返回0，前者大于后者返回1，若小于返回-1
	 */
	public static int compare(String decimalLiteral1, String decimalLiteral2) {
		decimalLiteral1 = decimalLiteral1.replaceAll(",", "");
		decimalLiteral2 = decimalLiteral2.replaceAll(",", "");
		return getDecimal(decimalLiteral1).compareTo(getDecimal(decimalLiteral2));
	}
	
	/**
	 * 
	 * <DL>
	 * <DT><B> 金额字符串补充小数位 XXX.XX </B></DT>
	 * @param str
	 * @return str
	 */
	public static String formatPriceStr(String str){
		if(str==null||str.trim().length()==0)
			return "";
		else {
			if(str.indexOf(".")!=-1){
			   return (str+"00").substring(0,str.indexOf(".")+3);
			} else {
			   return str+".00";
			}
		} 
			
	}
	
	/**   
     * 将元为单位的转换为分 替换小数点，支持以逗号区分的金额  
     *   
     * @param amount  
     * @return  
     */    
    public static String changeY2F(String amount){    
        String currency =  amount.replaceAll("\\$|\\￥|\\,", "");  //处理包含, ￥ 或者$的金额    
        int index = currency.indexOf(".");    
        int length = currency.length();    
        Long amLong = 0l;    
        if(index == -1){    
            amLong = Long.valueOf(currency+"00");    
        }else if(length - index >= 3){    
            amLong = Long.valueOf((currency.substring(0, index+3)).replace(".", ""));    
        }else if(length - index == 2){    
            amLong = Long.valueOf((currency.substring(0, index+2)).replace(".", "")+0);    
        }else{    
            amLong = Long.valueOf((currency.substring(0, index+1)).replace(".", "")+"00");    
        }    
        return amLong.toString();    
    }    
	
	/**
	 * 判断是double
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str){ 
		boolean isD=false;
		try{ 
			Double.parseDouble(str);
			isD=true;
		}catch(Exception e){ 
			e.printStackTrace();
		} 
		return isD;
	 } 
    
	 public static String formatNumeric(String numeric, String pattern) {
		if(StringUtil.isEmpty(numeric))
			return "";
		else {
			return formatNumeric(new BigDecimal(numeric.replaceAll(",", "")),pattern);
		}
	 }
	 
	 public static String formatNumeric(BigDecimal numeric, String pattern) {
	 	if (numeric == null)
	    	return "";
		DecimalFormat decFormat = new DecimalFormat(pattern);
		return decFormat.format(numeric);
	 }
	 
	 public static void main(String[] args){
		 System.out.println(formatNumeric("1000.0161","##,###.00"));
	 }
}
