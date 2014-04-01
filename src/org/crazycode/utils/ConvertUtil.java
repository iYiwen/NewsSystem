package org.crazycode.utils;

/**
 * 用于格式转换的工具类
 * @author Administrator
 *
 */
public class ConvertUtil {
	/**
	 * 将传入的字符串转换为Integer数据类型
	 * @param convertStr
	 * @return
	 */
	public static Integer StringConvertToInteger(String convertStr){
		if(!CommonsUtil.isNull(convertStr) && !CommonsUtil.isEmptyStr(convertStr)){
			return Integer.parseInt(convertStr);
		}
		return 0;
	}
	
}
