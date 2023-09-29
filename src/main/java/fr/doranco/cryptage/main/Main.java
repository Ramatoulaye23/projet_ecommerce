package fr.doranco.cryptage.main;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Main {

	public static void main(String[] args) {

		try {
			//generation DES generate key
			String messageToEncrypt = "Bonjour de la part de Rama !";
			System.out.println("Message d'origine : " + messageToEncrypt);
			KeyGenerator keyGen = KeyGenerator.getInstance("DES");
			keyGen.init(56);// initiation variable keyGen
			SecretKey key = keyGen.generateKey();
			System.out.println("Clé de cryptage : " + key.getEncoded());
			//Cipher utiliser pour crypter une clef ou decrypter :il a besoin de DES (generate key)du mode de crytage ou decryptage
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] messageInByte = messageToEncrypt.getBytes("UTF-8");
			byte[] messageEncrypte = cipher.doFinal(messageInByte);
			System.out.println("Message encrypté : " + new String(messageEncrypte));
			
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] messageDecrypteInByte = cipher.doFinal(messageEncrypte);
			String messageDecrypte = new String(messageDecrypteInByte, "UTF-8");
			System.out.println("Message décrypté : " + messageDecrypte);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

