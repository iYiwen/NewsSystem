package org.crazycode.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;
import org.springframework.web.util.WebUtils;

public class WebUtil extends WebUtils{

	/**
	 * 根据传入的name参数在request对象中获取对应的值
	 * @param request
	 * @param name
	 * @return
	 */
	public static Object getParametersWithRequest(ServletRequest request,String name){
		Assert.notNull(request, "Request对象不能为空!");
		return request.getParameter(name);
	}
	/**
	 * 判断传入的两个参数是否相等，都为null时不相等
	 * @param descParam
	 * @param srcParam
	 * @return
	 */
	public static Boolean checkEquals(Object descParam,Object srcParam){
		Boolean flag = false;
		flag = descParam==null?(srcParam==null?false:(srcParam.equals(descParam))):descParam.equals(srcParam);
		return flag;
	}
	/**
	 * 生成json的访问种子
	 * @param request
	 */
	public static void getSeed(HttpServletRequest request){
		String []seeds = {"1","A","a","2","B","b","3","C","c","4","D","d","5","E","e","6","F","f","7","G","g","8","H","h","9","I","i","0","J","j",
				"K","k","L","l","M","m","N","n","O","o","P","p","Q","q","R","r","S","s","T","t","U","u","V","v","W","w","X","x","Y","y","Z","z"};
		StringBuilder seed = new StringBuilder();
		for(int i=0;i<31;i++){
			seed.append(seeds[((int)(Math.random()*62))]);
		}
		request.getSession().setAttribute("seed", seed.toString());
	}
	/**获取系统的时间 	格式为：yyyy-MM-dd HH:mm:ss*/
	public static String getLongDate(){
		String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		return date;
	}
	/**获取系统的时间	格式为：yyyy-MM-dd*/
	public static String getShortDate(){
		String date=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		return date;
	}
	public static Date StringConvertToDate(String pattern){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return dateFormat.parse(pattern);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取客户端的IP地址
	 * @param request
	 * @return
	 */
	public static String getIP(HttpServletRequest request){
		return request.getRemoteAddr();
	}
}
