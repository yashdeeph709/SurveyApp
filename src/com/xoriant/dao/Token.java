package com.xoriant.dao;

import java.security.MessageDigest;

public class Token {
	String Token;

	public Token(String token) {
		super();
		Token = MD5(token);
	}
	public static String MD5(String md5) {
		   try {
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}
	@Override
	public boolean equals(Object obj) {
		Token token=(Token) obj;
		if(this.Token.equals(token.Token)){
			return true;
		}
		return false;
	}
}
