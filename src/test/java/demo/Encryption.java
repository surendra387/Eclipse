package demo;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.testng.annotations.Test;
public class Encryption {
	public static String encodedUsername;
	public static String encodedPassword;
	
@Test
	public void encrypt() throws IllegalBlockSizeException, BadPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException {
		
        // Provided key and initialization vector (IV) as hexadecimal strings
        String keyHex = UserLogin.enc_K;
        String ivHex = UserLogin.enc_N;

        // Username and password to encrypt
        String username = "ADMIN";
        String password = "Test@123";

        // Convert the key and IV from hexadecimal to bytes
        byte[] keyBytes = hexStringToByteArray(keyHex);
        byte[] ivBytes = hexStringToByteArray(ivHex);

        // Create a SecretKeySpec for the key
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "AES");

        // Initialize the Cipher in encryption mode with CBC and PKCS5Padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(ivBytes));

        // Encrypt the username and password
        byte[] encryptedUsername = cipher.doFinal(username.getBytes());
        byte[] encryptedPassword = cipher.doFinal(password.getBytes());

        // Encode the encrypted bytes in Base64
         encodedUsername = Base64.getEncoder().encodeToString(encryptedUsername);
        encodedPassword = Base64.getEncoder().encodeToString(encryptedPassword);

        // Print the results in the desired format
        System.out.println( encodedUsername);
        System.out.println(encodedPassword);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
	
	   
	}


