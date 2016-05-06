package com.utils;

import java.security.MessageDigest;

import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class MD5Encoder implements PasswordEncoder {

	public String encodePassword(String origPwd, Object salt)
			throws DataAccessException {
		return getMD5ofStr(origPwd);
	}

	public boolean isPasswordValid(String encPwd, String origPwd, Object salt)
			throws DataAccessException {
		return encPwd.equals(encodePassword(origPwd, salt));
	}

	public static String getMD5ofStr(String origString) {
		String origMD5 = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] result = md5.digest(origString.getBytes());
			origMD5 = byteArray2HexStr(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return origMD5;
	}

	/**
	 * 澶勭悊瀛楄妭鏁扮粍寰楀埌MD5瀵嗙爜鐨勬柟娉�
	 */
	private static String byteArray2HexStr(byte[] bs) {
		StringBuffer sb = new StringBuffer();
		for (byte b : bs) {
			sb.append(byte2HexStr(b));
		}
		return sb.toString();
	}

	/**
	 * 瀛楄妭鏍囧噯绉讳綅杞崄鍏繘鍒舵柟娉�
	 */
	private static String byte2HexStr(byte b) {
		String hexStr = null;
		int n = b;
		if (n < 0) {
			// 鑻ラ渶瑕佽嚜瀹氫箟鍔犲瘑,璇蜂慨鏀硅繖涓Щ浣嶇畻娉曞嵆鍙�
			n = b & 0x7F + 128;
		}
		hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
		return hexStr.toUpperCase();
	}

	/**
	 * 鎻愪緵涓�釜MD5澶氭鍔犲瘑鏂规硶
	 */
	public static String getMD5ofStr(String origString, int times) {
		String md5 = getMD5ofStr(origString);
		for (int i = 0; i < times - 1; i++) {
			md5 = getMD5ofStr(md5);
		}
		return getMD5ofStr(md5);
	}

	/**
	 * 瀵嗙爜楠岃瘉鏂规硶
	 */
	public static boolean verifyPassword(String inputStr, String MD5Code) {
		return getMD5ofStr(inputStr).equals(MD5Code);
	}

	/**
	 * 澶氭鍔犲瘑鏃剁殑瀵嗙爜楠岃瘉鏂规硶
	 */
	public static boolean verifyPassword(String inputStr, String MD5Code,
			int times) {
		return getMD5ofStr(inputStr, times).equals(MD5Code);
	}
		public static void main(String[] args) {
		System.out.println("1234:" + getMD5ofStr("1234"));
		System.out.println("6112071:" + getMD5ofStr("6112071"));
		System.out.println("admin:" + getMD5ofStr("admin").toLowerCase());
		System.out.println("123:" + getMD5ofStr("123", 4));
	}
}
