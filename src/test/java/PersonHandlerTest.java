import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonHandlerTest {
    @Test
    void addPersonTest(){
        PersonHandler ph = new PersonHandler();
        Person p = new Person("Jonathan Roman","9155555555","testPhoneService");
        ph.addPerson("Jonathan Roman","9155555555","testPhoneService");
        List<Person> people = ph.getGroupMembers();
        assertEquals(p.getName()+p.getPhoneNumber()+p.getPhoneService(),
                people.get(0).getName()+people.get(0).getPhoneNumber()+people.get(0).getPhoneService());
    }

    @Test
    void generateGifteesTest(){
        PersonHandler ph = new PersonHandler();
        ph.addPerson("Jonathan Roman","9155555555","testPhoneService");
        ph.addPerson("random person1","1111111111","testPhoneService1");
        ph.addPerson("random person2","2222222222","testPhoneService2");
        ph.addPerson("random person3","3333333333","testPhoneService3");
        ph.addPerson("random person4","4444444444","testPhoneService4");
        ph.addPerson("random person5","5555555555","testPhoneService5");
        ph.addPerson("random person6","6666666666","testPhoneService6");
        ph.addPerson("random person7","7777777777","testPhoneService7");
        ph.addPerson("random person8","8888888888","testPhoneService8");
        ph.addPerson("random person9","9999999999","testPhoneService9");
        ph.addPerson("random person10","0000000000","testPhoneService0");
        ph.addPerson("random person11","1212121212","testPhoneService11");
        ph.addPerson("random person12","1313131313","testPhoneService12");
        List<String> rdmGiftees = ph.generateGiftees();
        List<Person> groupMembers = ph.getGroupMembers();

        for(int i = 0; i< rdmGiftees.size();i++){
            assertEquals(rdmGiftees.indexOf(groupMembers.get(i).getName()), rdmGiftees.lastIndexOf(groupMembers.get(i).getName()));
            assertNotEquals(rdmGiftees.get(i),groupMembers.get(i).getName());
        }
    }

    @Test
    void generateGifteesEmptyList() {
        PersonHandler ph = new PersonHandler();
        assertNotNull(ph.generateGiftees());
    }

}
