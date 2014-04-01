package org.crazycode.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 用于MD5加密
 * @author Administrator
 *
 */
public class MD5Util{
	/**
	 * 将传入的字符串通过MD5加密然后返回加密后的字符串
	 * @param str
	 * @return
	 */
    public static String convertToMD5(String str) {
        String s=str;
		if(s==null){
			return "";
		}else{
			String value = null;
			MessageDigest md5 = null;
			try {
					md5 = MessageDigest.getInstance("MD5");
				}catch (NoSuchAlgorithmException ex) {
					Logger.getLogger(MD5Util.class.getName()).log(Level.SEVERE, null, ex);
				}
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder();
			try {
					value = baseEncoder.encode(md5.digest(s.getBytes("utf-8")));
				} catch (Exception ex) {
					
				}
			return value;
		}
	} 
    public static void main(String[] args) {
		System.out.println(convertToMD5("admin"));
	}
}
