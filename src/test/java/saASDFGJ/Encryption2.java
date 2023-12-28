package saASDFGJ;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

public class Encryption2 {

    public static void main(String[] args) throws Exception {
        // Replace "YourSecretKey" and "YourNonce" with your actual key and nonce
        String key = "404759e4c04b050f14d1fcf6a5b5aab7b3ae25f9a419b6b394df3bfd381c22d7";
        String nonce = "899aef5c41fa3d38f0beb0d9225aec58";

        String username = "ADMIN";
        String password = "Test@12345";

        // Encrypt the username and password
        String encUsername = encrypt(username, key, nonce);
        String encPassword = encrypt(password, key, nonce);

        // Print the encrypted values in the desired format
        System.out.println( encUsername);
        System.out.println(  encPassword);
    }

    public static String encrypt(String input, String key, String nonce) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey secretKey = generateSecretKey(key);

        // Ensure the IV is exactly 16 bytes long
        byte[] nonceBytes = new byte[16];
        byte[] originalNonce = nonce.getBytes(StandardCharsets.UTF_8);
        System.arraycopy(originalNonce, 0, nonceBytes, 0, Math.min(originalNonce.length, nonceBytes.length));
        IvParameterSpec ivSpec = new IvParameterSpec(nonceBytes);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));

        // Encode to Base64 for a printable string
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    private static SecretKey generateSecretKey(String key) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom(key.getBytes(StandardCharsets.UTF_8));
        keyGen.init(256, secureRandom);
        return keyGen.generateKey();
    }
}
