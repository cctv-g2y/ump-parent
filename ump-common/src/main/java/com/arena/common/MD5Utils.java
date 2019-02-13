package com.arena.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 *
 * @author guofazhan
 * @version [版本号, 2019/2/13 0013 0001]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class MD5Utils {
	/**
	 * 全局数组
	 */
	private final static String[] STRINGS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
			"f" };

	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return STRINGS[iD1] + STRINGS[iD2];
	}

	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		if (bByte == null) {
			return sBuffer.toString();
		}
		for (int i = 0; i < bByte.length; i++) {
			sBuffer.append(byteToArrayString(bByte[i]));
		}
		return sBuffer.toString();
	}

	/**
	 * MD5加密
	 *
	 * @param orgStr
	 * @return
	 * @throws Exception
	 */
	public static String md5(String orgStr) throws NoSuchAlgorithmException {
		String resultStr = null;
		if (null != orgStr && !"".equals(orgStr.trim())) {
			resultStr = byteToString(MessageDigest.getInstance("MD5").digest(orgStr.getBytes()));
		}
		return resultStr;
	}
}
