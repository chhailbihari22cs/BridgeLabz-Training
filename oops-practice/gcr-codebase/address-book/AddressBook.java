import java.util.ArrayList;
import java.util.Iterator;

/*
 * UC 2: AddressBook HAS-A ContactPerson
 * UC 3: Edit Contact
 * UC 4: Delete Contact
 * UC 5: Add Multiple Contacts
 * UC 7: Prevent Duplicate Entry
 */
public class AddressBook {

    // UC 2 & UC 5: Collection to store multiple contacts
    private ArrayList<ContactPerson> contacts = new ArrayList<>();

    /*
     * UC 5: Add multiple persons
     * UC 7: Check duplicate before adding
     */
    public void addContact(ContactPerson person) {
        if (contacts.contains(person)) { // UC 7
            System.out.println("Duplicate contact found. Not added.");
        } else {
            contacts.add(person);
            System.out.println("Contact added successfully.");
        }
    }

    /*
     * UC 3: Edit contact using person's name
     */
    public void editContact(String firstName) {
        for (ContactPerson person : contacts) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.println("Contact found. Edit logic can be applied.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    /*
     * UC 4: Delete contact using person's name
     */
    public void deleteContact(String firstName) {
        Iterator<ContactPerson> iterator = contacts.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getFirstName().equalsIgnoreCase(firstName)) {
                iterator.remove();
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Getter for UC 8, 9, 10
    public ArrayList<ContactPerson> getContacts() {
        return contacts;
    }

    // Display all contacts
    public void displayContacts() {
        contacts.forEach(ContactPerson::display);
    }
}
