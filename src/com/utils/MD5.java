package com.utils;

import java.security.MessageDigest;

/**
 * 閺嶅洤鍣疢D5閸旂姴鐦戦弬瑙勭《閿涘奔濞囬悽鈺va缁绨遍惃鍓唀curity閸栧懐娈慚essageDigest缁顦甸敓锟�BR>
 * 娑旂喎褰查崣妯硅礋闂堢偞鐖ｉ崙鍝匘5閿涘矁顕穱顔芥暭娑撳娼伴惃鍕╂担宥囩暬閿燂拷
 * 
 * @author Nanlei
 * 
 */
public class MD5 {
	/**
	 * 閼惧嘲绶盡D5閸旂姴鐦戠�鍡欑垳閻ㄥ嫭鏌熼敓锟�	 */
	public  String getMD5ofStr(String origString) {
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
	 * 婢跺嫮鎮婄�妤勫Ν閺佹壆绮嶅妤�煂MD5鐎靛棛鐖滈惃鍕煙閿燂拷
	 */
	private  String byteArray2HexStr(byte[] bs) {
		StringBuffer sb = new StringBuffer();
		for (byte b : bs) {
			sb.append(byte2HexStr(b));
		}
		return sb.toString();
	}

	/**
	 * 鐎涙濡弽鍥у櫙缁夎缍呮潪顒�磩閸忣叀绻橀崚鑸垫煙閿燂拷
	 */
	private  String byte2HexStr(byte b) {
		String hexStr = null;
		int n = b;
		if (n < 0) {
			// 閼汇儵娓剁憰浣藉殰鐎规矮绠熼崝鐘茬槕,鐠囪渹鎱ㄩ弨纭呯箹娑擃亞些娴ｅ秶鐣诲▔鏇炲祮閿燂拷
			n = b & 0x7F + 128;
		}
		hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
		return hexStr.toUpperCase();
	}

	/**
	 * 閹绘劒绶甸敓锟介敓鏂ゆ嫹MD5婢舵碍顐奸崝鐘茬槕閺傝纭�
	 */
	public  String getMD5ofStr(String origString, int times) {
		String md5 = getMD5ofStr(origString);
		for (int i = 0; i < times - 1; i++) {
			md5 = getMD5ofStr(md5);
		}
		return getMD5ofStr(md5);
	}

	/**
	 * 鐎靛棛鐖滄宀冪槈閺傝纭�
	 */
	public  boolean verifyPassword(String inputStr, String MD5Code) {
		return getMD5ofStr(inputStr).equals(MD5Code);
	}

	/**
	 * 婢舵碍顐奸崝鐘茬槕閺冨墎娈戠�鍡欑垳妤犲矁鐦夐弬瑙勭《
	 */
	public  boolean verifyPassword(String inputStr, String MD5Code,
			int times) {
		return getMD5ofStr(inputStr, times).equals(MD5Code);
	}

	/**
	 * 閹绘劒绶甸敓锟介敓鏂ゆ嫹濞村鐦惃鍕瘜閸戣姤鏆�
	 */
//	public static void main(String[] args) {
//		System.out.println("123:" + getMD5ofStr("123"));
//		System.out.println("123456789:" + getMD5ofStr("123456789"));
//		System.out.println("pioneer:" + getMD5ofStr("pioneer"));
//		System.out.println("123:" + getMD5ofStr("123", 4));
//	}
}
