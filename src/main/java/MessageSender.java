import java.util.List;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class MessageSender {
    private final String VERIZON_SERVICE = "VERIZON";
    private final String ATT_SERVICE = "ATT";
    private final String TMOBILE_SERVICE = "TMOBILE";
    private final String MINT_MOBILE_SERVICE = "MINT";
    private final String CRICKET_WIRELESS = "CRICKET";

    public final String VERIZON = "@vtext.com";
    public final String ATT = "@txt.att.net";
    public final String TMOBILE = "@tmomail.net";
    public final String MINT_MOBILE = "@mailmymobile.net";
    public final String CRICKET = "@mms.cricketwireless.net";
    public final String BOOST_MOBILE = "";
    public final String SPRINT = "";
    public final String METRO_PCS = "";
    public final String GOOGLE_FI = "";






    private final String USERNAME = "";
    private final String PASSWORD = "";
    private Properties properties;
    private Session session;

    //Constructor
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

    /**
     * Send a message with a subject line to an address.
     *
     * @param recipientEmail Email address to which the message is being sent.
     * @param subjectLine Subject line of the message.
     * @param message Message being sent.
     * @return True if message was sent successfully false otherwise
     */
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

    /**
     * Send messages to the list of gifters containing the name of their giftee.
     *
     * @param gifters List of people to recieve messages.
     * @param giftees List of names of the giftees.
     * @return true if successfull false otherwise.
     */
    public boolean sendMessages(List<Person> gifters, List<String> giftees){
        if(gifters.size() != giftees.size()){
            return false;
        }
        for(int i = 0; i<gifters.size();i++){
            String phoneNumber = gifters.get(i).getPhoneNumber();
            switch (gifters.get(i).getPhoneService()){
                case VERIZON_SERVICE:
                    phoneNumber+=VERIZON;
                    break;
                case ATT_SERVICE:
                    phoneNumber+=ATT;
                    break;
                case TMOBILE_SERVICE:
                    phoneNumber+=TMOBILE;
                    break;
                case MINT_MOBILE_SERVICE:
                    phoneNumber+= MINT_MOBILE;
                    break;
                case CRICKET:
                    phoneNumber+= CRICKET;
                default:
                    continue;
            }
            this.sendMessage(phoneNumber,"Hi! " + gifters.get(i).getName(), "you are getting a gift for " + giftees.get(i));
        }
            return true;
    }



}
