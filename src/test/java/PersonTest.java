import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    void getNameTest(){
        String name = "testName";
        Person p = new Person(name,"1111111111","testingservice");
        assertEquals(name,p.getName());
    }

    @Test
    void getNumberTest(){
        String phoneNumber = "1111111111";
        Person p = new Person("testName", phoneNumber, "testingservice");
        assertEquals(phoneNumber, p.getPhoneNumber());
    }

    @Test
    void getPhoneServiceTest(){
        String phoneService = "testingservice";
        Person p = new Person("testName", "1111111111", phoneService);
        assertEquals(phoneService, p.getPhoneService());
    }
}
