package com.akajdev.crypto;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ResourceBundle;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SecurityUtil {

    private PrivateKey privateKey;
    private PublicKey publicKey;
    private static final ResourceBundle RESOURCES = ResourceBundle.getBundle("com.akajdev.crypto.properties.resources");
    private static final String KEYFACTORY_ALGO = RESOURCES.getString("crypto.keyfactory.algorithm");
    private static final String CIPHER_ALGO = RESOURCES.getString("crypto.cipher.algorithm");
    private static final int keySize = Integer.parseInt(RESOURCES.getString("crypto.keysize"));
    private static final Charset charset = Charset.forName(RESOURCES.getString("crypto.charset"));
    private static final String PROVIDER = RESOURCES.getString("crypto.provider");
    private static final String KEYFACTORY_PROVIDER = RESOURCES.getString("crypto.keyfactory.cipher");

    public SecurityUtil(String keyStoreFile, String keyAlias, String password) throws Exception {
        try (FileInputStream fis = new FileInputStream(keyStoreFile)) {
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

            ks.load(fis, password.toCharArray());
            setPrivateKey((PrivateKey) ks.getKey(keyAlias, password.toCharArray()));

            Certificate cert = ks.getCertificate(keyAlias);
            setPublicKey(cert.getPublicKey());
        }
    }

    public SecurityUtil(String keyPath, boolean isPrivate) throws Exception {
        //Read key files back and decode them from BASE64
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] keyBytes;
        try (FileInputStream fis = new FileInputStream(keyPath)) {
            keyBytes = decoder.decodeBuffer(fis);
        }

        // Convert back to public and private key objects
        KeyFactory keyFactory = KeyFactory.getInstance(KEYFACTORY_ALGO, KEYFACTORY_PROVIDER);
        KeySpec keySpec;
        if (!isPrivate) {
            keySpec = new X509EncodedKeySpec(keyBytes);
            setPublicKey(keyFactory.generatePublic(keySpec));
        } else {
            keySpec = new PKCS8EncodedKeySpec(keyBytes);
            setPrivateKey(keyFactory.generatePrivate(keySpec));
        }
    }

    public SecurityUtil() {
    }

    public String encryptString(String data) {
        try {
            String encrtyptedString = "";
            try {
                Cipher cipher = Cipher.getInstance(CIPHER_ALGO, PROVIDER);
                cipher.init(Cipher.ENCRYPT_MODE, getPublicKey());

                byte[] encodeVal = blockCipher(cipher, data.getBytes(charset), Cipher.ENCRYPT_MODE);
                encrtyptedString = new BASE64Encoder().encode(encodeVal);
                encrtyptedString = encrtyptedString.replaceAll("\\r|\\n", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return encrtyptedString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public String decryptString(String encryptedData) {
        try {
            String decrtyptedString = "";
            try {
                Cipher cipher = Cipher.getInstance(CIPHER_ALGO, PROVIDER);
                cipher.init(Cipher.DECRYPT_MODE, getPrivateKey());

                byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
                byte[] decValue = blockCipher(cipher, decordedValue, Cipher.DECRYPT_MODE);
                decrtyptedString = new String(decValue, charset).trim();

            } catch (NoSuchAlgorithmException | NoSuchProviderException | NoSuchPaddingException | InvalidKeyException | IOException | IllegalBlockSizeException | BadPaddingException e) {
                e.printStackTrace();
            }
            return decrtyptedString;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @return the privateKey
     */
    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    /**
     * @param privateKey the privateKey to set
     */
    private void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    /**
     * @return the publicKey
     */
    public PublicKey getPublicKey() {
        return publicKey;
    }

    /**
     * @param publicKey the publicKey to set
     */
    private void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    private static byte[] blockCipher(Cipher cipher, byte[] bytes, int mode) throws IllegalBlockSizeException, BadPaddingException {
        // string initialize 2 buffers.
        // scrambled will hold intermediate results

        byte[] scrambled = new byte[0];

        // toReturn will hold the total result
        byte[] toReturn = new byte[0];
        try {
            // if we encrypt we use 100 byte long blocks. Decryption requires 128 byte long blocks (because of RSA)
            int length = (mode == Cipher.ENCRYPT_MODE) ? (keySize / 8) - 11 : keySize / 8;

            // another buffer. this one will hold the bytes that have to be modified in this step
            byte[] buffer = new byte[(bytes.length > length ? length : bytes.length)];

            for (int i = 0; i < bytes.length; i = i + length) {
                // here we calculate the length of the next buffer required
                int newlength = length;

                // this step is needed if we had a trailing buffer. should only happen when encrypting.
                // example: we encrypt 110 bytes. 100 bytes per run means we "forgot" the last 10 bytes. they are in the buffer array
                // if newlength would be longer than remaining bytes in the bytes array we shorten it.
                if (i + length > bytes.length) {
                    newlength = bytes.length - i;
                    //set the buffer array to the remaining bytes array
                    buffer = new byte[newlength];
                }
                // copy byte into our buffer.
                System.arraycopy(bytes, i, buffer, 0, newlength);

                // if we filled our buffer array we have our block ready for de- or encryption
                //execute the operation
                scrambled = cipher.doFinal(buffer);

                // add the result to our total result.
                toReturn = append(toReturn, scrambled);

                // clean the buffer array
                buffer = new byte[newlength];
            }

        } catch (BadPaddingException | IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    private static byte[] append(byte[] prefix, byte[] suffix) {
        byte[] toReturn = new byte[prefix.length + suffix.length];
        try {
            System.arraycopy(prefix, 0, toReturn, 0, prefix.length);

            System.arraycopy(suffix, 0, toReturn, prefix.length, suffix.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    public void loadPublicKey(String publicKeyPath) throws Exception {
        PublicKey pubKey = null;
        try {
            byte[] encodedPublicKey;
            try (FileInputStream fis = new FileInputStream(publicKeyPath)) {
                encodedPublicKey = new BASE64Decoder().decodeBuffer(fis);
            }

            KeyFactory keyFactory = KeyFactory.getInstance(KEYFACTORY_ALGO, KEYFACTORY_PROVIDER);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
                    encodedPublicKey);
            pubKey = keyFactory.generatePublic(publicKeySpec);

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            ex.printStackTrace();
        }
        setPublicKey(pubKey);
    }

    public void loadPrivateKey(String privateKeyPath) throws Exception {
        PrivateKey priKey = null;
        try {
            byte[] encodedPrivateKey;
            try (FileInputStream fis = new FileInputStream(privateKeyPath)) {
                encodedPrivateKey = new BASE64Decoder().decodeBuffer(fis);
            }

            KeyFactory keyFactory = KeyFactory.getInstance(KEYFACTORY_ALGO, KEYFACTORY_PROVIDER);
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
            priKey = keyFactory.generatePrivate(privateKeySpec);

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            ex.printStackTrace();
        }
        setPrivateKey(priKey);
    }
}
