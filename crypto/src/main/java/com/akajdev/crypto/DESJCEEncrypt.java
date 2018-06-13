package com.akajdev.crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class DESJCEEncrypt {

    public void cipherEncryptDecrypt(String strToCipher) {
	try {

	    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
	    SecretKey myDesKey = keygenerator.generateKey();

	    Cipher desCipher;

	    //	    Algorithm name : DES = Data Encryption Standard.
	    //	    Mode (optional) : ECB = Electronic Codebook mode.
	    //	    Padding scheme (optional) : PKCS5Padding = PKCS #5-style padding.
	    // Create the cipher 
	    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

	    // Initialize the cipher for encryption
	    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

	    //sensitive information
	    byte[] text = strToCipher.getBytes();

	    System.out.println("Text [Byte Format] : " + text);
	    System.out.println("Text : " + new String(text));

	    // Encrypt the text
	    byte[] textEncrypted = desCipher.doFinal(text);

	    System.out.println("Text Encrypted : " + textEncrypted);

	    // Initialize the same cipher for decryption
	    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

	    // Decrypt the text
	    byte[] textDecrypted = desCipher.doFinal(textEncrypted);

	    System.out.println("Text Decrypted : " + new String(textDecrypted));

	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
