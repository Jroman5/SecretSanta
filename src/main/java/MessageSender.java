import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MessageSender {
    private final String USERNAME = "";
    private final String PASSWORD = "";
    private Properties properties;
    private Session session;

    public MessageSender(){

        this.properties = System.getProperties();

        // Setup mail server
        // Be sure to look up the settings required by the SMTP server you're using
        this.properties.put("mail.user", this.USERNAME);
        this.properties.put("mail.password", this.PASSWORD);
        this.properties.put("mail.smtp.auth", "true");
        this.properties.put("mail.smtp.starttls.enable", "true");
        this.properties.put("mail.smtp.host", "smtp.mail.yahoo.com");
        this.properties.put("mail.smtp.port","587");
        this.session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
        session.setDebug(true);

    }
    public boolean sendMessage(String recipientEmail, String subjectLine, String message){
        try{
            MimeMessage mimeMessage = new MimeMessage(session);
            // Set From: header field of the header.
            mimeMessage.setFrom(new InternetAddress(this.USERNAME));

            // Set To: header field of the header.
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

            // Set Subject: header field
            mimeMessage.setSubject(subjectLine);

            // Now set the actual message
            mimeMessage.setText(message);

            // Send message
            Transport.send(mimeMessage);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
            return false;
        }
        return true;
    }

}
