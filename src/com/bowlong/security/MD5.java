package com.bowlong.security;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class MD5 {

	/*** 自封的MD5加密规则 **/
	static private final String md5(byte[] v) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
			mdAlgorithm.update(v);
			byte[] mdCode = mdAlgorithm.digest();

			int mdCodeLength = mdCode.length;
			char strMd5[] = new char[mdCodeLength * 2];
			int k = 0;
			for (int i = 0; i < mdCodeLength; i++) {
				byte byte0 = mdCode[i];
				strMd5[k++] = hexDigits[byte0 >>> 4 & 0xf];
				strMd5[k++] = hexDigits[byte0 & 0xf];
			}
			mdCode = null;
			return new String(strMd5);
		} catch (Exception e) {
			return "";
		}
	}

	/*** MD5加密方式 得32位 **/
	static public final String MD5Encode(String s) {
		byte[] b = s.getBytes();
		return md5(b);
	}

	static public final byte[] MD5Bytes(byte[] v) {
		return md5(v).getBytes();
	}

	/*** 默认的MD5加密方式 **/
	static public final String toMD5(String plain) {
		if (plain == null)
			return "";

		return toMD5(plain.getBytes());
	}

	/*** 默认的MD5加密方式 **/
	static public final String toMD5(byte[] v) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(v);
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/*** MD5加密方式 取得16位 **/
	static public final String MD5EncodeF16(String str) {
		String v32 = MD5Encode(str);
		return v32.substring(8, 24);
	}

	/*** UUID+System.currentTimeMillis 值 MD5加密方式 取得32位 **/
	static public final String MD5UUIDStime() {
		UUID uuid = UUID.randomUUID();
		String ss = uuid.toString() + System.currentTimeMillis();
		return MD5Encode(ss);
	}

	static public final String MD5UUIDStimeF16() {
		String v32 = MD5UUIDStime();
		return v32.substring(8, 24);
	}

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String ss = uuid.toString() + System.currentTimeMillis();
		System.out.println(uuid.toString());
		System.out.println(ss);
		System.out.println(MD5.toMD5(ss));
		System.out.println(MD5.MD5Encode(ss));
		System.out.println(MD5.MD5EncodeF16(ss));
	}
}
