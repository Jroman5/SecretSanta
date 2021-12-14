import java.io.File;
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
     * Reads the file given and appends the people to the list of groupMembers
     *
     * @param file File to read to add people to the group members
     * @return true if addition is successful false otherwise
     */
    public boolean addFromFile(File file){
        return false;
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
