package com.akajdev.crypto;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class CipherUsingCodec {
    
    public String cipherEncrypt(String plain) {

	String encstr = "";
	try {
	    byte[] encryptArray = Base64.encodeBase64(plain.getBytes());
	    encstr = new String(encryptArray, "UTF-8");
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
	return encstr;
    }

    public String cipherDecrypt(String encrypted) {

	String decstr = "";
	try {
	    byte[] dectryptArray = encrypted.getBytes();
	    byte[] decarray = Base64.decodeBase64(dectryptArray);
	    decstr = new String(decarray, "UTF-8");
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}
	return decstr;
    }

}
