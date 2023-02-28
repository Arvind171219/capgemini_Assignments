import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Add Contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Search contact by phone");
            System.out.println("4. Remove contact");
            System.out.println("5. Exit");

            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("\nAdd a Contact:");
                    System.out.print("Enter the First Name: ");
                    String firstName = scanner.next();
                    System.out.print("Enter the Last Name: ");
                    String lastName = scanner.next();
                    System.out.print("Enter the Phone No.: ");
                    long phoneNumber = scanner.nextLong();
                    System.out.print("Enter the Email: ");
                    String emailId = scanner.next();
                    Contact contact = new Contact(firstName, lastName, phoneNumber, emailId);
                    boolean success = phoneBook.addContact(contact);
                    if (success)
                        System.out.println("Contact added successfully!");
                    else System.out.println("Failed to add contact!");
                }
                case 2 -> {
                    List<Contact> contacts = phoneBook.viewAllContacts();
                    if (contacts.isEmpty()) {
                        System.out.println("Phone book is empty!");
                    } else {
                        System.out.println("\nThe contacts in the List are:");
                        for (Contact c : contacts) {
                            System.out.println(c);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("\nEnter the Phone number to search contact: ");
                    long phoneNo = scanner.nextLong();
                    Contact searchedContact = phoneBook.viewContactByPhoneNo(phoneNo);
                    if (searchedContact == null) {
                        System.out.println("Contact not found!");
                    } else {
                        System.out.println("\nThe contact is:");
                        System.out.println(searchedContact);
                    }
                }
                case 4 -> {
                    System.out.print("\nEnter the Phone number to remove: ");
                    long phoneToRemove = scanner.nextLong();
                    System.out.print("Do you want to remove the contact (Y/N): ");
                    String confirm = scanner.next();
                    if (confirm.equalsIgnoreCase("Y")) {
                        boolean removed = phoneBook.removeContact(phoneToRemove);

                        if (removed) {
                            System.out.println("The contact is successfully deleted.");
                        } else {
                            System.out.println("Contact not found!");
                        }
                    }
                }
                case 5 -> {
                    System.out.println("\nExiting the application...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("\nInvalid choice. Please try again.");
            }
        }
        }
    }