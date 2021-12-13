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

    public void addPerson(String name, String phoneNumber, String phoneService){
        this.groupMembers.add(new Person(name, phoneNumber, phoneService));
    }

}
