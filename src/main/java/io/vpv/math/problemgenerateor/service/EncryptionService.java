package io.vpv.math.problemgenerateor.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

/**
 * Created by vprasanna on 2/8/19.
 */
@Component
@Scope("singleton")
public class EncryptionService {
    @Value("${app.aeskey:''}")
    private String keyStr;

    private static final byte[] IV_RAND = {89, -27, 127, -87, -19, -69, -76, -91, 97, -52, -19, -34, -48, -46, -99, -9};

    public void setKeyStr(String keyStr) {
        this.keyStr = keyStr;
    }

    private Key aesKey = null;
    private Cipher cipher = null;

    synchronized private void init() throws Exception {
        if (keyStr == null || keyStr.length() != 16) {
            throw new Exception("bad aes key configured");
        }
        if (aesKey == null) {
            aesKey = new SecretKeySpec(keyStr.getBytes(), "AES");
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        }
    }

    /*
     * DO NOT DELETE`
     *
     * Use this commented code if you don't like using DatatypeConverter dependency
     */
//    public static String toHexStringOld(byte[] bytes) {
//        StringBuilder sb = new StringBuilder();
//        for (byte b : bytes) {
//            sb.append(String.format("%02X", b));
//        }
//        return sb.toString();
//    }
//
//    public static byte[] toByteArrayOld(String s) {
//        int len = s.length();
//        byte[] data = new byte[len / 2];
//        for (int i = 0; i < len; i += 2) {
//            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i +
//                    1), 16));
//        }
//        return data;
//    }

    public static String toHexString(byte[] array) {
        return DatatypeConverter.printHexBinary(array);
    }

    public static byte[] toByteArray(String s) {
        return DatatypeConverter.parseHexBinary(s);
    }

    synchronized public String encrypt(String text) throws Exception {
        init();
        IvParameterSpec ivspec = new IvParameterSpec(IV_RAND);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey, ivspec);
        return toHexString(cipher.doFinal(text.getBytes()));
    }

    synchronized public String decrypt(String text) throws Exception {
        init();
        IvParameterSpec ivspec = new IvParameterSpec(IV_RAND);
        cipher.init(Cipher.DECRYPT_MODE, aesKey, ivspec);
        return new String(cipher.doFinal(toByteArray(text)));
    }

}
