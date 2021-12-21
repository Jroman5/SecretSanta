import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        try{
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                String nextLine = scanner.nextLine();
                String[] personValues = nextLine.split(",");
                this.addPerson(personValues[0], personValues[1], personValues[2]);
            }
        }catch(FileNotFoundException fileNotFoundException){
            fileNotFoundException.printStackTrace();
            return false;
        }
        return true;
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

    /**
     * Takes the List<Person> groupMembers and randomizes the names
     * such that groupMemebers.get(i).getName != giftees.get(i)
     * && every name in groupMembers is in giftees
     * && groupMembers.size() == giftees.size()
     * @return giftees List of giftee names
     */
    public List<String> generateGiftees(){
        List<String> giftees = new ArrayList();
        for(int i = 0; i<this.groupMembers.size();i++){
            int giftee = (int)(Math.random() * this.groupMembers.size());
            while(giftees.contains(this.groupMembers.get(giftee).getName()) || giftees.size() == giftee){
                giftee = (int)(Math.random() * this.groupMembers.size());
            }
            giftees.add(this.groupMembers.get(giftee).getName());

        }
        return giftees;
    }

    public int getSize(){
        return this.groupMembers.size();
    }

}
