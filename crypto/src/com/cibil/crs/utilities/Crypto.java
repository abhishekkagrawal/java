/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cibil.crs.utilities;

import java.io.File;
import java.util.UUID;

/**
 *
 * @author abhagraw
 */
public class Crypto {

    private static String key = "S4E26D0565D8B26AB9D661542A15308V";
//f925916e2754e5e03f75dd58a5733251

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        EncryptDecrypt ed = new EncryptDecrypt();
        try {
            File publicKeyFile = new File(Crypto.class.getResource("/com/cibil/crs/utilities/keys/YesBank-PublicKey.key").getFile());
            File privateKeyFile = new File(Crypto.class.getResource("/com/cibil/crs/utilities/keys/YesBank-PrivateKey.key").getFile());

            System.out.println("Base64 Encode:" + EncryptDecrypt.base64Encode("3987563397564578"));
            System.out.println("Base64 Decode:" + EncryptDecrypt.base64Decode(EncryptDecrypt.base64Encode("3987563397564578")));

            String encryptedString = EncryptDecrypt.md5Encrypt("Test@123");
            System.out.println("One Way MD5 Encrypt - (Used in LDAP user password CRS): " + encryptedString + " of length:" + encryptedString.length());

            String decryptedString = EncryptDecrypt.md5Decrypt(EncryptDecrypt.md5Encrypt("Test@123"));
            System.out.println("One Way MD5 Decrypt - (Used in LDAP user password CRS): " + decryptedString + " of length:" + decryptedString.length());

            encryptedString = EncryptDecrypt.encrypt("Test@123");
            System.out.println("Encrypt - AES Algo with Key: " + encryptedString + " of length:" + encryptedString.length());

            decryptedString = EncryptDecrypt.decrypt(EncryptDecrypt.encrypt("Test@123"));
            System.out.println("Decrypt - AES Algo with Key: " + decryptedString + " of length:" + decryptedString.length());

            encryptedString = EncryptDecrypt.getSHA1EncryptedString("Test@123");
            System.out.println("One Way Encrypt SHA1 with HEX key: " + encryptedString + " of length:" + encryptedString.length());

            encryptedString = EncryptDecrypt.getMD5Checksum("Test@123");
            System.out.println("One way MD5 encrypt : " + encryptedString + " of length:" + encryptedString.length());

            encryptedString = EncryptDecrypt.Encrypt("Test@123", key);
            System.out.println("Two way encrypt AES Algo & Key: " + encryptedString + " of length:" + encryptedString.length());

            decryptedString = EncryptDecrypt.Decrypt(EncryptDecrypt.Encrypt("Test@123", key), key);
            System.out.println("Two way decrypt AES Algo & Key: " + decryptedString + " of length:" + decryptedString.length());

            String guid = UUID.randomUUID().toString();
            System.out.println("GUID: " + guid + " of length:" + guid.length());

            ed.setKeyPath(publicKeyFile.getAbsolutePath());
            encryptedString = ed.encryptInput("Test@123");
            System.out.println("Two Way Encrypt: " + encryptedString + " of length:" + encryptedString.length());

            ed.setKeyPath(privateKeyFile.getAbsolutePath());
            decryptedString = ed.decryptInput(encryptedString);
            System.out.println("Two Way Decrypt: " + decryptedString + " of length:" + decryptedString.length());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
