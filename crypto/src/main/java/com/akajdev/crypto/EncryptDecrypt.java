package com.akajdev.crypto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Used to encrypt and decrypt password.
 *
 * @author Aditya Joshi
 */
public final class EncryptDecrypt {

    /**
     * Object of EncryptDecrypt.
     */
    private static EncryptDecrypt instance;

    /**
     * private cipheronstruciphertor :only this cipherlass cipheran allow
     * cipherreate objeciphert
     */
    public EncryptDecrypt() {
        // Exists only to defeat instantiation.
    }

    /**
     * Method to get EncryptDecrypt instance.
     *
     * @return instance of EncryptDecrypt.
     */
    public static EncryptDecrypt getInstance() {
        if (instance == null) {
            instance = new EncryptDecrypt();
        }
        return instance;
    }
    private String keyPath = "";
    private static final String ALGO = "AES";
    private static final byte[] KEYVALUE
            = new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't',
                'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y',};

    public static String base64Encode(String data) {
        String encryptedValue = "";
        try {
            byte[] encVal = data.getBytes();
            encryptedValue = new BASE64Encoder().encode(encVal);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return encryptedValue;
    }

    public static String base64Decode(String data) {
        String decryptedValue = "";
        try {
            byte[] decordedValue = new BASE64Decoder().decodeBuffer(data);
            decryptedValue = new String(decordedValue);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return decryptedValue;
    }

    /**
     * Method to encrypt password.
     *
     * @param data to be encrypted.
     * @return String
     */
    public static String encrypt(String data) {
        String encryptedValue = "";
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = cipher.doFinal(data.getBytes());
            encryptedValue = new BASE64Encoder().encode(encVal);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return encryptedValue;
    }

    /**
     * Method to decrypt encrypted data.
     *
     * @param encryptedData encrypted data.
     * @return decrypted data.
     */
    public static String decrypt(String encryptedData) {
        String decryptedValue = "";
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
            byte[] decValue = cipher.doFinal(decordedValue);
            decryptedValue = new String(decValue);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return decryptedValue;
    }

    private static Key generateKey() {
        return new SecretKeySpec(KEYVALUE, ALGO);
    }

    public static String md5Encrypt(String password) {
        String encryptedPassword = "";
        try {
            java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(password.getBytes("UTF-8"));
            byte[] rawData = md5.digest();
            BASE64Encoder base_encoder = new BASE64Encoder();
            encryptedPassword = base_encoder.encode(rawData);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return encryptedPassword;
    }

    public static String md5Decrypt(String password) {
        String decryptedValue = "";
        try {
            java.security.MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");
            md5.reset();
//            md5.update(password.getBytes("UTF-8"));
            BASE64Decoder base_decoder = new BASE64Decoder();
//            encryptedPassword
            byte[] decordedValue = base_decoder.decodeBuffer(password);
            md5.update(decordedValue);
            byte[] decValue = md5.digest();
            decryptedValue = new String(decValue);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return decryptedValue;
    }

    /**
     * <b style="color:green">
     * Method Name: </b><span
     * style="color:green">getSHA1EncryptedString</span><br>
     * Author: </b><span style="color:green">Rajesh chikkala</span><br>
     * <b style="color:green">
     * Description: </b><span style="color:green">
     * This method for getting Encrypted String from normal string
     * </span><br>
     */
    public static String getSHA1EncryptedString(String normalString) {
        String encodedString = "";
        // for encryption
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA1");// can be replaced with MD5
            // SHA1 has fewer collisions in comparison with MD5.
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }

        byte[] passwordByte = normalString.getBytes();
        md.update(passwordByte, 0, passwordByte.length);
        byte[] encodedNormalString = md.digest(); // compute the digest
        encodedString = toHexString(encodedNormalString);

        return encodedString;
    }

    public static String toHexString(byte[] buf) {
        char[] hexChar = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        StringBuilder strBuf = new StringBuilder(buf.length * 2);
        for (byte element : buf) {
            strBuf.append(hexChar[(element & 0xf0) >>> 4]); // fill left with
            // zero bits
            strBuf.append(":");
            strBuf.append(hexChar[element & 0x0f]);
        }
        return strBuf.toString();
    }

    // GETCHECKSUM
    public static String getMD5Checksum(String data) throws Exception {
        //System.out.println("getMD5Checksum(String data)begin");
        byte[] b = createChecksum(data);
        String result = "";
        for (byte element : b) {
            result += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
        }
        //System.out.println("getMD5Checksum(String data)end");
        return result;
    }

    private static byte[] createChecksum(String data) throws Exception {
        //System.out.println("createChecksum(String data) begin");
        InputStream fis = new ByteArrayInputStream(data.getBytes());
        byte[] buffer = new byte[1024];
        MessageDigest complete = MessageDigest.getInstance("MD5");
        int numRead;
        do {
            numRead = fis.read(buffer);
            if (numRead > 0) {
                complete.update(buffer, 0, numRead);
            }
        } while (numRead != -1);
        fis.close();
        //System.out.println("createChecksum(String data) end");
        return complete.digest();
    }

    public static String Decrypt(String text, String key)
            throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(2, keySpec, ivSpec);
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] results = cipher.doFinal(decoder.decodeBuffer(text));
        return new String(results, "UTF-8");
    }

    public static String Encrypt(String text, String key)
            throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[16];
        byte[] b = key.getBytes("UTF-8");
        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
        cipher.init(1, keySpec, ivSpec);

        byte[] results = cipher.doFinal(text.getBytes("UTF-8"));
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(results);
    }

    /**
     *
     * @return the KeyPath
     */
    public final String getKeyPath() {
        return this.keyPath;
    }

    /**
     *
     * @param keyPath the keyPath to set
     */
    public final void setKeyPath(final String keyPath) {
        this.keyPath = keyPath;
    }

    /**
     * Decrypt the input encrypted XML String
     *
     * @param encryptedString Encrypted XML String
     * @param keyAlias Key Alias String
     * @param password Password String
     * @return Decrypted String
     */
    public final String decryptInput(final String encryptedString) {
        String simpleString = "";
        try {
            SecurityUtil su = new SecurityUtil(getKeyPath(), true);
            simpleString = su.decryptString(encryptedString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return simpleString;
    }

    /**
     * Encrypt the input decrypted XML String
     *
     * @param simpleString Simple XML String
     * @param keyAlias Key Alias String
     * @param password Password String
     * @return Encrypted String
     */
    public final String encryptInput(final String simpleString) {
        String encryptedString = "";
        try {
            SecurityUtil su = new SecurityUtil(getKeyPath(), false);
            encryptedString = su.encryptString(simpleString);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return encryptedString;
    }

}
