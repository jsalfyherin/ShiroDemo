package com.example.demo.common.util;

import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串相关方法
 */
public class StringUtil {
	
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String changeStr(String str){
		if(isEmpty(str))
			return "";
		else if("null".equals(str.toLowerCase())){
			//ios端接收到"null"会显示不正常
			return " "+str;
		} else
			return str;
	}

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr) {
		int i = 0;
		String TempStr = valStr;
		String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
		valStr = valStr + ",";
		while (valStr.indexOf(',') > 0) {
			returnStr[i] = valStr.substring(0, valStr.indexOf(','));
			valStr = valStr.substring(valStr.indexOf(',') + 1, valStr.length());

			i++;
		}
		return returnStr;
	}
	
	/**
	 * 检测字符串是否不为空(null,"","null")
	 * @param s
	 * @return 不为空则返回true，否则返回false
	 */
	public static boolean notEmpty(String s){
		return s!=null && !"".equals(s) && !"null".equals(s);
	}
	
	/**
	 * 检测字符串是否为空(null,"","null")
	 * @param s
	 * @return 为空则返回true，不否则返回false
	 */
	public static boolean isEmpty(String s){
		return s==null || "".equals(s) || "null".equals(s);
	}
	
	/**
     * 字符串前面去0方法
     * @param s
     * @return
     * 2015-9-21
     * 下午02:21:49
     * autor:lujianhui
     */
    public static final String discardZero(String s) {
        StringBuffer stringbuffer = new StringBuffer(s);
        while(stringbuffer.substring(0,1).equals("0"))
        {
        	if(stringbuffer.length()==1){
        		break;
        	}
       	 	stringbuffer.delete(0,1);
        }
        return stringbuffer.toString();
    }
    
    /**
     * 字符串补0方法
     * @param s
     * @param i
     * @return
     * autor:lujianhui
     */
    public static final String prefixZero(String s, int i) {
        StringBuffer stringbuffer = new StringBuffer(i);
        for (int j = 0; j < i - s.length(); j++) {
            stringbuffer.append('0');
        }
        stringbuffer.append(s);
        return stringbuffer.toString();
    }
    
    
	 /**
	  * 验证手机号码
	  * @param mobiles
	  * @return
	  */
	 public static boolean checkMobileNumber(String mobileNumber){
	  boolean flag = false;
	  try{
	    Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
	    Matcher matcher = regex.matcher(mobileNumber);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }
	 
	 /**
	  * 验证邮箱
	  * @param email
	  * @return
	  */
	 public static boolean checkEmail(String email){
	  boolean flag = false;
	  try{
	    String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
	    Pattern regex = Pattern.compile(check);
	    Matcher matcher = regex.matcher(email);
	    flag = matcher.matches();
	   }catch(Exception e){
	    flag = false;
	   }
	  return flag;
	 }
    
    /**
   	 * 获取指定长度的随机数
   	 * @param length 随机数长度
   	 * @return
   	 */
   	public static String getRandomData( int length ){
   		Random random = new Random(); 
   		String val="";
   		for(int i = 0; i < length; i++){   	      
   			val += String.valueOf(random.nextInt(10));    
   		} 
   		return val;
   	}
   	
   	public static String StringReplace(String str){
		//最后一个字符
		String[] arr=new String[]{"&Alpha;","&Beta;","&Gamma;","&Delta;","&Epsilon;","&Zeta;","&Eta;","&Theta;","&Iota;","&Kappa;","&Lambda;","&Mu;",
				"&Nu;","&Xi;","&Omicron;","&Pi;","&Rho;","&Sigma;","&Tau;","&Upsilon;","&Phi;","&Chi;","&Psi;","&Omega;",
				"&alpha;","&beta;","&gamma;","&delta;","&epsilon;","&zeta;","&eta;","&theta;","&iota;","&kappa;","&lambda;","&mu;",
				"&nu;","&xi;","&omicron;","&pi;","&rho;","&sigmaf;","&sigma;","&tau;","&upsilon;","&phi;","&chi;","&psi;",
				"&omega;","&thetasym;","&upsih;","&piv;","&bull;","&hellip;","&prime;","&Prime;","&oline;","&frasl;","&weierp;","&image;",
				"&real;","&trade;","&alefsym;","&larr;","&uarr;","&rarr;","&darr;","&harr;","&crarr;","&lArr;","&uArr;","&rArr;",
				"&dArr;","&hArr;","&forall;","&part;","&exist;","&empty;","&nabla;","&isin;","&notin;","&ni;","&prod;","&sum;",
				"&minus;","&lowast;","&radic;","&prop;","&infin;","&ang;","&and;","&or;","&cap;","&cup;","&int;","&there4;",
				"&sim;","&cong;","&asymp;","&ne;","&equiv;","&le;","&ge;","&sub;","&sup;","&nsub;","&sube;","&supe;",
				"&oplus;","&otimes;","&perp;","&sdot;","&lceil;","&rceil;","&lfloor;","&rfloor;","&loz;","&spades;","&clubs;","&hearts;",
				"&diams;","&nbsp;","&iexcl;","&cent;","&pound;","&curren;","&yen;","&brvbar;","&sect;","&uml;","&copy;","&ordf;",
				"&laquo;","&not;","&shy;","&reg;","&macr;","&deg;","&plusmn;","&sup2;","&sup3;","&acute;","&micro;","&quot;",
				"&lt;","&gt;","&ldquo;","&rdquo;","&#39;","&rsquo;","&mdash;","&ndash;","&middot;","&lsquo;","&amp;","&frac34;",
				"&aring;","&lsaquo;","&Auml;","&eacute;","&auml;","&egrave;","&frac12;","&rsaquo;","&raquo;"};
		String[] arr1=new String[]{"Α","Β","Γ","Δ","Ε","Ζ","Η","Θ","Ι","Κ","Λ","Μ",
				"Ν","Ξ","Ο","Π","Ρ","Σ","Τ","Υ","Φ","Χ","Ψ","Ω",
				"α","β","γ","δ","ε","ζ","η","θ","ι","κ","λ","μ",
				"ν","ξ","ο","π","ρ","ς","σ","τ","υ","φ","χ","ψ",
				"ω","ϑ","ϒ","ϖ","•","…","′","″","‾","⁄","℘","ℑ",		
				"ℜ","™","ℵ","←","↑","→","↓","↔","↵","⇐","⇑","⇒",	
				"⇓","⇔","∀","∂","∃","∅","∇","∈","∉","∋","∏","∑",		
				"−","∗","√","∝","∞","∠","∧","∨","∩","∪","∫","∴",		
				"∼","≅","≈","≠","≡","≤","≥","⊂","⊃","⊄","⊆","⊇",		
				"⊕","⊗","⊥","⋅","⌈","⌉","⌊","⌋","◊","♠","♣","♥",		
				"♦"," ","¡","¢","£","£","¥","¦","§","¨","©","ª",
				"«","¬"," ","®","¯","°","±","²","³","´","µ","\"",		
				"<",">","“","”","'","’","—","–","·","‘","&","?",
				"å","‹","Ä","é","ä","è","?","›","?"};
		for(int i=0;i<arr.length;i++){
			if(str.indexOf(arr[i])>=0){
				str=str.replace(arr[i], arr1[i]);
				i=0;
			}
		}
		return str;
	}
   	
    /**
   	 * 对模糊真实姓名的名字
   	 * @param userName
   	 * @return
   	 */
   	public static String vagueName(String userName){
   		if(StringUtil.isEmpty(userName)){
   			return "";
   		}
   		if(userName.length()<=1){
   			return userName;
   		}
   		StringBuffer sb = new StringBuffer(userName.substring(0, 1));
   		for(int i=1;i<userName.length();i++){
   			sb.append("*");
   		}
   		return sb.toString();
   	}
   	
   	public static void main(String[] args){
   		System.out.println(vagueName(null));
   	}
}
