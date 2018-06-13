/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akajdev.crypto;

import java.io.File;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author abhagraw
 */
public class Crypto {

    private static String key = "S4E26D0565D8B26AB9D661542A15308V";
    //f925916e2754e5e03f75dd58a5733251

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

	EncryptDecrypt ed = new EncryptDecrypt();
	try {
	    String stringToEncrypt = "908464674553";
	    File publicKeyFile = new File(Crypto.class.getResource("/com/akajdev/crypto/keys/PublicKey.key").getFile());
	    File privateKeyFile = new File(Crypto.class.getResource("/com/akajdev/crypto/keys/PrivateKey.key").getFile());

	    String encryptedString = EncryptDecrypt.base64Encode(stringToEncrypt);
	    System.out.println("Base64 Encode:" +  encryptedString);	    
	    String decryptedString = EncryptDecrypt.base64Decode(encryptedString);
	    System.out.println("Base64 Decode:" + decryptedString);
	    
	    encryptedString=StringUtils.reverse(encryptedString);
	    System.out.println("Reveresed - Base64 Encode:" + encryptedString );
	    decryptedString = EncryptDecrypt.base64Decode(StringUtils.reverse(encryptedString));
	    System.out.println("Base64 Decode after Reversed back:" + decryptedString);

	    encryptedString = EncryptDecrypt.md5Encrypt(stringToEncrypt);
	    System.out.println("One Way MD5 Encrypt - (Used in LDAP user password CRS): " + encryptedString + " of length:" + encryptedString.length());

	    decryptedString = EncryptDecrypt.md5Decrypt(EncryptDecrypt.md5Encrypt(stringToEncrypt));
	    System.out.println("One Way MD5 Decrypt - (Used in LDAP user password CRS): " + decryptedString + " of length:" + decryptedString.length());

	    encryptedString = EncryptDecrypt.encrypt(stringToEncrypt);
	    System.out.println("Encrypt - AES Algo with Key: " + encryptedString + " of length:" + encryptedString.length());

	    decryptedString = EncryptDecrypt.decrypt(EncryptDecrypt.encrypt(stringToEncrypt));
	    System.out.println("Decrypt - AES Algo with Key: " + decryptedString + " of length:" + decryptedString.length());

	    encryptedString = EncryptDecrypt.getSHA1EncryptedString(stringToEncrypt);
	    System.out.println("One Way Encrypt SHA1 with HEX key: " + encryptedString + " of length:" + encryptedString.length());

	    encryptedString = EncryptDecrypt.getMD5Checksum(stringToEncrypt);
	    System.out.println("One way MD5 encrypt : " + encryptedString + " of length:" + encryptedString.length());

	    encryptedString = EncryptDecrypt.Encrypt(stringToEncrypt, key);
	    System.out.println("Two way encrypt AES Algo & Key: " + encryptedString + " of length:" + encryptedString.length());

	    decryptedString = EncryptDecrypt.Decrypt(EncryptDecrypt.Encrypt(stringToEncrypt, key), key);
	    System.out.println("Two way decrypt AES Algo & Key: " + decryptedString + " of length:" + decryptedString.length());

	    String guid = UUID.randomUUID().toString();
	    System.out.println("GUID: " + guid + " of length:" + guid.length());

	    System.out.println("StringUtils Random :" + RandomStringUtils.randomAlphanumeric(16));

	    DESJCEEncrypt desjceEncrypt = new DESJCEEncrypt();
	    desjceEncrypt.cipherEncryptDecrypt(stringToEncrypt);

	    CipherUsingOffset cipherUsingOffset = new CipherUsingOffset();
	    encryptedString = cipherUsingOffset.caesarCipherEncrypt(stringToEncrypt);
	    System.out.println("Cipher Using Offset - Encrypt:" + encryptedString);

	    decryptedString = cipherUsingOffset.caesarCipherDecrypt(encryptedString);
	    System.out.println("Cipher Using Offset - Decrypt:" + decryptedString);

	    CipherUsingCodec cipherUsingCodec = new CipherUsingCodec();
	    encryptedString = cipherUsingCodec.cipherEncrypt(stringToEncrypt);
	    System.out.println("Cipher Using Codec - Encrypt:" + encryptedString);

	    decryptedString = cipherUsingCodec.cipherDecrypt(encryptedString);
	    System.out.println("Cipher Using Codec - Decrypt:" + decryptedString);

	    String key = CipherUsingKeys.keyGenerator(128);
	    //StringUtils.upperCase(RandomStringUtils.randomAlphanumeric(32));
	    encryptedString = CipherUsingKeys.encryptUsingKey(key, stringToEncrypt);
	    System.out.println("Cipher using key - Encrypt:" + encryptedString);

	    decryptedString = CipherUsingKeys.decryptUsingKey(key, encryptedString);
	    System.out.println("Cipher using key - Decrypt:" + decryptedString);

	    ed.setKeyPath(publicKeyFile.getAbsolutePath());
	    encryptedString = ed.encryptInput(stringToEncrypt);
	    System.out.println("Two Way Encrypt: " + encryptedString + " of length:" + encryptedString.length());

	    ed.setKeyPath(privateKeyFile.getAbsolutePath());
	    decryptedString = ed.decryptInput(encryptedString);
	    System.out.println("Two Way Decrypt: " + decryptedString + " of length:" + decryptedString.length());

	} catch (Exception ex) {
	    ex.printStackTrace();
	}
    }

}
