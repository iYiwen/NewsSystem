package org.crazycode.utils;

import java.util.HashMap;
import java.util.Map;

public class CommonsUtil {

	/**
	 * 判断是否为空
	 * @param obj
	 * @return
	 */
	public static Boolean isNull(Object obj){
		return obj==null?true:false;
	}
	/**
	 * 判断是否为空字符串
	 * @param str
	 * @return
	 */
	public static Boolean isEmptyStr(String str){
		if(isNull(str)){
			throw new IllegalArgumentException("字符串参数为空!");
		}
		return str.equals("")?true:false;
	}
	public static boolean isEmpty(String s) {
		if (null == s || "".equals(s) || "".equals(s.trim()) || "null".equalsIgnoreCase(s)) {
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 将传入的参数拼装成参数Map
	 * 参数的格式为("key",value,"key",value,...)依此类推
	 * @param paramStr
	 * @return
	 */
	public static Map<String,Object> getMap(Object ...paramStr){
		Map<String,Object> map = new HashMap<String, Object>();
		String key;
		Object value;
		if(paramStr!=null && paramStr.length>0){
			for(int i=0;i<paramStr.length;i=i+2){
				key=(String)paramStr[i];
				value = paramStr[i+1];
				map.put(key, value);
			}
		}
		return map;
	}
}
