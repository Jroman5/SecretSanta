import java.util.ArrayList;
import java.util.List;

public class PersonHandler {
    private List<Person> groupMembers;

    public PersonHandler(){
        this.groupMembers = new ArrayList<>();
    }


    public List<Person> getGroupMembers() {
        return groupMembers;
    }

    /**
     * adds a new person to the list of members in the group
     *
     * @param name name of person
     * @param phoneNumber phone number associated to person
     * @param phoneService phone service used by person
     */
    public void addPerson(String name, String phoneNumber, String phoneService){
        this.groupMembers.add(new Person(name, phoneNumber, phoneService));
    }

}
