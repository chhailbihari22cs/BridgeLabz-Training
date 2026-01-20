import java.util.Objects;

/*
 * UC 1: Ability to create a Contact Person
 * UC 7: Override equals() to check duplicate entry
 */
public class ContactPerson {
    // UC 1: Contact attributes
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;
    // UC 1: Constructor to create contact
    public ContactPerson(String firstName, String lastName, String address,
                         String city, String state, String zip,
                         String phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    // UC 2: Encapsulation – getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getCity() { return city; }
    public String getState() { return state; }

    // UC 7: Duplicate check using equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactPerson)) return false;
        ContactPerson that = (ContactPerson) o;
        return firstName.equalsIgnoreCase(that.firstName) &&
                lastName.equalsIgnoreCase(that.lastName);
    }
    // UC 7: Override hashCode()
    @Override
    public int hashCode() {
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }
    // Display contact
    public void display() {
        System.out.println(firstName + " " + lastName +
                " | " + city + " | " + state +
                " | " + phoneNumber + " | " + email);
    }
}
