package com.gfs.tools;

import java.io.UnsupportedEncodingException;

public class Charset {
	
	public static String toUTF8(String str) throws UnsupportedEncodingException{
		return Charset.changeCharset(str,"ISO-8859-1", "UTF-8");
	}
	
	public static String changeCharset(String str, String oldCharset, String newCharset)  
		      throws UnsupportedEncodingException {  
		     if (str != null) {  
		      //用旧的字符编码解码字符串。解码可能会出现异常。  
		      byte[] bs = str.getBytes(oldCharset);  
		      //用新的字符编码生成字符串  
		      return new String(bs, newCharset);  
		     }  
		     return null;  
		    }    
}
