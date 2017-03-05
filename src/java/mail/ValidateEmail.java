package mail;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class ValidateEmail {

  

 	public static boolean check(String email) {
		boolean isValid = false;
		try {
			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			isValid = true;
		} catch (AddressException e) {
			System.out.println("You are in catch block -- Exception Occurred for: " + email);
		}
		return isValid;
	}

 
}