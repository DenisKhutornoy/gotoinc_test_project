package com.company;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class CryptClass {
    private SecretKey secretKey;

    public void setSecretKey(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String toCode(String word, int n) {
        if (word == null || word.isEmpty() || n <= 0) {
            return word;
        } else {
            for (int i = 0; i < n; i++) {
                char[] chars = word.toCharArray();
                StringBuilder even = new StringBuilder();
                StringBuilder odd = new StringBuilder();
                for (int j = 0; j < chars.length; j++) {
                    if (j % 2 == 0) {
                        even.append(chars[j]);
                    } else {
                        odd.append(chars[j]);
                    }
                }
                word = odd.toString() + even.toString();
            }
        }
        return word;
    }

    public String deCode(String word, int n) {
        char[] fresh = new char[0];
        if (word == null || word.isEmpty() || n <= 0) {
            return null;
        } else {
            for (int a = 0; a < n; a++) {
                char[] chars = word.toCharArray();
                fresh = new char[chars.length];
                int k = 1;
                int z = chars.length / 2;

                for (int i = 0; i < chars.length; i++) {
                    if (i < chars.length / 2) {
                        if (i + k < chars.length) {
                            fresh[i + k] = chars[i];
                            k++;
                        }
                    } else if (i >= chars.length / 2) {
                        if (i - z >= 0) {
                            fresh[i - z] = chars[i];
                            z--;
                        }
                    }
                    word = new String(fresh);
                }
            }
        }
        String nWordh = new String(fresh);
        return nWordh;
    }


    public byte[] encrypt(String text, int n) throws InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, NoSuchAlgorithmException {
        String str = toCode(text,n);
        System.out.println(" After first step :  "+ str);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bytes = cipher.doFinal(str.getBytes());
        System.out.println("\nEncrypted:");
        for (byte b : bytes) {
            System.out.print(b);
        }
        return bytes;
    }

    public String decrypt(byte[] encryptedText,int n) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Cipher decryptCipher = Cipher.getInstance("AES");
        decryptCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = decryptCipher.doFinal(encryptedText);
        System.out.println("\nDecrypted:");
        for (byte b : decryptedBytes) {
            System.out.print(b);
        }
        String decryptedText = new String(decryptedBytes);
        System.out.println("\n \n" +
                " Intermediate decryption result: " + decryptedText);

        String result = deCode(decryptedText,n);
        return result;
    }
}
