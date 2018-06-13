package com.akajdev.crypto;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class CipherUsingKeys {
    public static final String AES = "AES";

    private static String byteArrayToHexString(byte[] b) {
	StringBuffer sb = new StringBuffer(b.length * 2);
	for (int i = 0; i < b.length; i++) {
	    int v = b[i] & 0xff;
	    if (v < 16) {
		sb.append('0');
	    }
	    sb.append(Integer.toHexString(v));
	}
	return sb.toString().toUpperCase();
    }

    private static byte[] hexStringToByteArray(String s) {
	byte[] b = new byte[s.length() / 2];
	for (int i = 0; i < b.length; i++) {
	    int index = i * 2;
	    int v = Integer.parseInt(s.substring(index, index + 2), 16);
	    b[i] = (byte) v;
	}
	return b;
    }

    public static String encryptUsingKey(String key, String plainText) {
	String encryptedString = "";
	try {
	    byte[] bytekey = hexStringToByteArray(key);
	    SecretKeySpec sks = new SecretKeySpec(bytekey, CipherUsingKeys.AES);
	    Cipher cipher = Cipher.getInstance(CipherUsingKeys.AES);
	    cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
	    byte[] encrypted = cipher.doFinal(plainText.getBytes());

	    encryptedString = byteArrayToHexString(encrypted);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return encryptedString;
    }

    public static String decryptUsingKey(String key, String encryptedString) {
	String originalString = "";
	try {
	    byte[] bytekey = hexStringToByteArray(key);
	    SecretKeySpec sks = new SecretKeySpec(bytekey, CipherUsingKeys.AES);
	    Cipher cipher = Cipher.getInstance(CipherUsingKeys.AES);
	    cipher.init(Cipher.DECRYPT_MODE, sks);
	    byte[] decrypted = cipher.doFinal(hexStringToByteArray(encryptedString));
	    originalString = new String(decrypted);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return originalString;
    }

    public static String keyGenerator(int keySize) {
	String key = "";
	try {
	    KeyGenerator keyGen = KeyGenerator.getInstance(CipherUsingKeys.AES);

	    keyGen.init(keySize);
	    SecretKey sk = keyGen.generateKey();
	    key = byteArrayToHexString(sk.getEncoded());
	    System.out.println("key:" + key);
	} catch (NoSuchAlgorithmException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return key;

    }
}
