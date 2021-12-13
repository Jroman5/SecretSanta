public class Person {
    private String name;
    private String phoneNumber;
    private String phoneService;

    public Person(){
        this.name = "NA";
        this.phoneNumber = "NA";
        this.phoneService = "NA";
    }

    public Person(String name, String phoneNumber, String phoneService){
        this.name = name;
        this.phoneService = phoneService;
        this.phoneNumber = phoneNumber;
    }

    //getters
    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getPhoneService(){
        return this.phoneService;
    }

}
