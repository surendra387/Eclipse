package saASDFGJ;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
public class Encryption {

	public static void main(String[] args) throws Exception {
        // Provided key and initialization vector (IV) as hexadecimal strings
        String keyHex = "78f833a0b94b997d1cac4a186081f1bf14eb2265b7bb2c7ef50753bdf8c49d94";
        String ivHex = "27750e2086dbdbc20e7b6af93796af3d";

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
        String encodedUsername = Base64.getEncoder().encodeToString(encryptedUsername);
        String encodedPassword = Base64.getEncoder().encodeToString(encryptedPassword);

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


