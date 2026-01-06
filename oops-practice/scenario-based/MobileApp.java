import java.util.ArrayList;
import java.util.Iterator;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

class InvalidPhoneNumberException extends Exception {
    InvalidPhoneNumberException(String msg) {
        super(msg);
    }
}

class ContactOrganizer {

    ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String number) throws InvalidPhoneNumberException {

        if (!number.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must be exactly 10 digits");
        }

        for (Contact c : contacts) {
            if (c.phoneNumber.equals(number)) {
                System.out.println("Duplicate phone numbers not allowed");
                return;
            }
        }

        contacts.add(new Contact(name, number));
        System.out.println("Contact added successfully");
    }

    public void deleteContact(String number) {

        Iterator<Contact> it = contacts.iterator();

        while (it.hasNext()) {
            Contact c = it.next();
            if (c.phoneNumber.equals(number)) {
                it.remove();
                System.out.println("Contact deleted successfully");
                return;
            }
        }
        System.out.println("Contact not found");
    }

    public void searchContact(String number) {

        for (Contact c : contacts) {
            if (c.phoneNumber.equals(number)) {
                System.out.println("Found: " + c.name + " - " + c.phoneNumber);
                return;
            }
        }
        System.out.println("Contact not found");
    }
}

public class MobileApp {

    public static void main(String[] args) {

        ContactOrganizer organizer = new ContactOrganizer();

        try {
            organizer.addContact("Harsh", "9876543210");
            organizer.addContact("Ankit", "9876543210"); // duplicate
            organizer.addContact("Rahul", "12345"); // invalid
        } catch (InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
        }

        organizer.searchContact("9876543210");
        organizer.deleteContact("9876543210");
        organizer.searchContact("9876543210");
    }
}
