import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Contact> phoneBook = new ArrayList<Contact>();

    public boolean addContact(Contact contactObj) {
        phoneBook.add(contactObj);
        System.out.println("Contact added successfully");
        return true;
    }

    public List<Contact> viewAllContacts() {
        return phoneBook;
    }

    public Contact viewContactByPhoneNo(long phoneNumber) {
        for (Contact contact : phoneBook) {
            if (contact.getPhoneNumber() == phoneNumber) {
                return contact;
            }
        }
        return null;
    }

    public boolean removeContact(long phoneNumber) {
        for (Contact contact : phoneBook) {
            if (contact.getPhoneNumber() == phoneNumber) {
                phoneBook.remove(contact);
                return true;
            }
        }
        return false;
    }
}
