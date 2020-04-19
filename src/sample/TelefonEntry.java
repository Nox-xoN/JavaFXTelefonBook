package sample;

public class TelefonEntry {
    private String firstName;
    private String lastName;
    private String number;


    public TelefonEntry(String firstName, String lastName, String number)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() { return firstName; }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setLastName(String newValue) {
        this.lastName = newValue;
    }

    public void setFirstName(String newValue) {
        this.firstName = newValue;
    }

    public void setNumber(String newValue) {
        this.number = newValue;
    }
}
