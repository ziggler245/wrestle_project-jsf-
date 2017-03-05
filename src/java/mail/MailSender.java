package mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 

public class MailSender {
 
	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
  
	public static void generateAndSendEmail(String email_value,String user_agent) throws AddressException, MessagingException {

		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
            
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email_value));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(email_value));
		generateMailMessage.setSubject("Security Notice from wwe.com");
		String emailBody = "On your account was made entry, IP:"+user_agent;
		generateMailMessage.setContent(emailBody, "text/html");
              	Transport transport = getMailSession.getTransport("smtp");
 
		transport.connect("smtp.gmail.com", "login", "password");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}