import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MessageSenderTest {

    @Test
    void sendMessageTest(){
        MessageSender ms = new MessageSender();
        String address = ""+ ms.MINT_MOBILE; //enter phone number
        String message = "test complete";
        String subjectLine = "this is a test";
        assertTrue(ms.sendMessage(address, subjectLine, message));
    }

    @Test
    void sendMessagesTest(){
        PersonHandler ph = new PersonHandler();
        for(int i = 0; i < 10;i++){
            String phoneNumber = ""; //enter phone number
            String phoneService = "MINT";
            ph.addPerson("person"+i ,phoneNumber,phoneService);
        }
        MessageSender ms = new MessageSender();
        assertTrue(ms.sendMessages(ph.getGroupMembers(), ph.generateGiftees()));
    }

    @Test
    void sendMessagesTestDifferentSizeLists(){
        PersonHandler ph = new PersonHandler();
        for(int i = 0; i < 10;i++){
            String phoneNumber = ""; //enter phone number
            String phoneService = "MINT";
            ph.addPerson("person"+i ,phoneNumber,phoneService);
        }
        List<String> giftees = new ArrayList<>();
        for(int i = 0; i < 5;i++){
            giftees.add("person"+i);
        }
        MessageSender ms = new MessageSender();
        assertFalse(ms.sendMessages(ph.getGroupMembers(), giftees));

    }

}
