package com.orderCraftSpringApp.utils;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtils {

    private static final String ALGORITHM = "AES";
    private static final byte[] KEY = "MySuperSecretKey".getBytes();

    public static String encrypt(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(EncryptionUtils.ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedByteValue = cipher.doFinal(value.getBytes("utf-8"));
        return Base64.getEncoder().encodeToString(encryptedByteValue);
    }

    public static String decrypt(String value) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(EncryptionUtils.ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedValue64 = Base64.getDecoder().decode(value);
        byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
        return new String(decryptedByteValue, "utf-8");
    }

    private static Key generateKey() throws Exception {
        return new SecretKeySpec(EncryptionUtils.KEY, EncryptionUtils.ALGORITHM);
    }
}