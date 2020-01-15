package com.company;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class Main {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, IllegalBlockSizeException {
        String text = "Some secret information";
        int count = 5;
        CryptClass cryptClass = new CryptClass();

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        cryptClass.setSecretKey(secretKey);

        System.out.println(" Text to encrypting :  " + text);

        byte[] bytes = cryptClass.encrypt(text, count);
        String result = cryptClass.decrypt(bytes, count);

        System.out.println(" Decryption result : " + result);
    }
}