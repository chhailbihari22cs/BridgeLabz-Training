import java.util.*;

/*
 * UC 6: Multiple Address Books with unique name
 * UC 8: Search person by City or State across Address Books
 * UC 9: Dictionary of City → Person and State → Person
 * UC 10: Count persons by City and State
 */
public class AddressBookSystem {

    // UC 6: Dictionary of AddressBook Name → AddressBook
    private Map<String, AddressBook> addressBookMap = new HashMap<>();

    // UC 9: Dictionary for City and State
    private Map<String, List<ContactPerson>> cityMap = new HashMap<>();
    private Map<String, List<ContactPerson>> stateMap = new HashMap<>();

    /*
     * UC 6: Add new Address Book with unique name
     */
    public void addAddressBook(String name) {
        if (addressBookMap.containsKey(name)) {
            System.out.println("Address Book already exists.");
        } else {
            addressBookMap.put(name, new AddressBook());
            System.out.println("Address Book created: " + name);
        }
    }

    // UC 6: Get Address Book
    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    /*
     * UC 9: Maintain City and State dictionary
     */
    public void addToCityStateMap(ContactPerson person) {
        cityMap.computeIfAbsent(person.getCity(), k -> new ArrayList<>()).add(person);
        stateMap.computeIfAbsent(person.getState(), k -> new ArrayList<>()).add(person);
    }

    /*
     * UC 8: Search persons by City
     */
    public void searchByCity(String city) {
        System.out.println("Persons in City: " + city);
        cityMap.getOrDefault(city, new ArrayList<>())
                .forEach(ContactPerson::display);
    }

    /*
     * UC 8: Search persons by State
     */
    public void searchByState(String state) {
        System.out.println("Persons in State: " + state);
        stateMap.getOrDefault(state, new ArrayList<>())
                .forEach(ContactPerson::display);
    }

    /*
     * UC 10: Count persons by City
     */
    public void countByCity() {
        System.out.println("Count by City:");
        cityMap.forEach((city, list) ->
                System.out.println(city + " : " + list.size()));
    }

    /*
     * UC 10: Count persons by State
     */
    public void countByState() {
        System.out.println("Count by State:");
        stateMap.forEach((state, list) ->
                System.out.println(state + " : " + list.size()));
    }
}
