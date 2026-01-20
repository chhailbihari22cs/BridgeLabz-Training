/*
 * UC 1 to UC 10: Main Driver Class
 */
public class AddressBookMain {

    public static void main(String[] args) {

        // UC 6: Create Address Book System
        AddressBookSystem system = new AddressBookSystem();

        // UC 6: Add Address Book
        system.addAddressBook("Personal");

        // UC 2: Get Address Book
        AddressBook book = system.getAddressBook("Personal");

        // UC 1: Create Contact Persons
        ContactPerson p1 = new ContactPerson(
                "Vishal", "Chaudhary", "Delhi",
                "Delhi", "Delhi", "110001",
                "9999999999", "v@email.com"
        );

        ContactPerson p2 = new ContactPerson(
                "Karan", "Sharma", "Mumbai",
                "Mumbai", "Maharashtra", "400001",
                "8888888888", "k@email.com"
        );

        // UC 5 + UC 7: Add contacts and prevent duplicate
        book.addContact(p1);
        book.addContact(p2);
        book.addContact(p1); // duplicate check

        // UC 9: Add contacts to City & State dictionary
        system.addToCityStateMap(p1);
        system.addToCityStateMap(p2);

        // UC 5: Display all contacts
        System.out.println("\nAll Contacts:");
        book.displayContacts();

        // UC 8: Search by City
        System.out.println("\nSearch by City:");
        system.searchByCity("Delhi");

        // UC 10: Count by City and State
        System.out.println("\nStatistics:");
        system.countByCity();
        system.countByState();
    }
}
