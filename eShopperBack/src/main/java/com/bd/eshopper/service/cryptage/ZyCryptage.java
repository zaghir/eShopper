package com.bd.eshopper.service.cryptage;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ZyCryptage {

	private static final String CRYPT_METHODE = "AES";
	
	public ZyCryptage() {

	}

	public String encrypt(String text, String clePrive) {

		// decode the base64 encoded string
		byte[] decodedKey = Base64.getDecoder().decode(clePrive);
		// rebuild key using SecretKeySpec
		SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, CRYPT_METHODE);

		Key k = originalKey;
		Cipher c;
		byte[] encyptValue = null;
		try {
			c = Cipher.getInstance(CRYPT_METHODE);
			c.init(c.ENCRYPT_MODE, k);
			System.out.println("text ------------ ------------- "+text);
			encyptValue = c.doFinal(text.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Base64.getEncoder().encodeToString(encyptValue);
	}

	public String decrypt(String text , String clePrive) {
		// decode the base64 encoded string
		byte[] decodedKey = Base64.getDecoder().decode(clePrive);
		// rebuild key using SecretKeySpec
		SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, CRYPT_METHODE);
		Key k = originalKey;
		Cipher c;
		byte[] decode64Value = null;
		byte[] decryptValue = null;
		try {
			c = Cipher.getInstance(CRYPT_METHODE);
			c.init(c.DECRYPT_MODE, k);
			decode64Value = Base64.getDecoder().decode(text);
			decryptValue = c.doFinal(decode64Value);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new String(decryptValue);

	}

	public String generatSecretKey() {
		try {
			KeyGenerator keyGen = KeyGenerator.getInstance(CRYPT_METHODE);

			keyGen.init(128);
			keyGen.generateKey();
			byte[] k = keyGen.getInstance(CRYPT_METHODE).generateKey().getEncoded();
			return Base64.getEncoder().encodeToString((k));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Unsupported algorithm: ??? , size: ??? " + e);
			return null;
		}
	}

	/*public static void main(String[] args) {

		ZyCryptage c = new ZyCryptage(); // "1v39eptlvuhaqqsr"		
		String clePrive = c.generatSecretKey();
		String text = "PA-00001-000001" ;
		String textCripte = c.encrypt(text, clePrive) ;
		System.out.println("cle privé :"+clePrive);
		System.out.println("text clair : "+text);
		System.out.println(" text cripté :"+textCripte);
		System.out.println(c.decrypt(textCripte , clePrive));

	}*/

}
