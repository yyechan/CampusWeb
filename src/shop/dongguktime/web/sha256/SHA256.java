package shop.dongguktime.web.sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	
	public static String encrypt(String str) {
		
		String sha256 = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(str.getBytes());
			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for(int i = 0 ; i < byteData.length ; i++) {
				sb.append(Integer.toString((byteData[i]&0xff) + 0x100,16).substring(1));
			}
			sha256 = sb.toString();
		}catch(NoSuchAlgorithmException e) {
			
			System.out.println("Encrypt Error");
			sha256 = null;
		}
		
		return sha256;
	}
	

}
