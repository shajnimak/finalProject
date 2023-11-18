package util.impl;

import pojo.entity.User;
import util.CryptoInterface;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoConverter implements CryptoInterface {
    private final User user;
    public CryptoConverter(User user) {
        this.user = user;
    }
    @Override
    public SecretKey getKey() {
        String key = "idkjXeYdJbxFvPYgRggXqO0LEcblAFrst8GARHGC7qQ=";
        byte[] decodedKey = Base64.getDecoder().decode(key);
        return new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    @Override
    public String encrypt() {
        String plainText = user.getPassword();
        try {
            byte[] plainTextByte = plainText.getBytes();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, getKey());
            byte[] encryptedByte = cipher.doFinal(plainTextByte);
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(encryptedByte);
        } catch (InvalidKeyException
                 | BadPaddingException
                 | IllegalBlockSizeException
                 | IllegalArgumentException
                 | NoSuchAlgorithmException
                 | NoSuchPaddingException
                 | NullPointerException ignored) {}
        return plainText;
    }

    @Override
    public String decrypt() {
        String encryptedText = user.getPassword();
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            byte[] encryptedTextByte = decoder.decode(encryptedText);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, getKey());
            byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
            return new String(decryptedByte);
        } catch (InvalidKeyException
                 | BadPaddingException
                 | IllegalBlockSizeException
                 | IllegalArgumentException
                 | NoSuchAlgorithmException
                 | NoSuchPaddingException
                 | NullPointerException ignored) {}
        return encryptedText;
    }
}
