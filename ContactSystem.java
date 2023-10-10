import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNO;
    private String email;

    public Contact(String name, String phoneNO, String email) {
        this.name = name;
        this.phoneNO = phoneNO;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getphoneNO() {
        return phoneNO;
    }

    public String getEmail() {
        return email;
    }

    public void setphoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNO + "\nEmail: " + email;
    }
}

public class ContactSystem {
    private static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Contacts");
            System.out.println("5. View All Contacts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addContact(scanner);
                    break;
                case 2:
                    editContact(scanner);
                    break;
                case 3:
                    deleteContact(scanner);
                    break;
                case 4:
                    searchContacts(scanner);
                    break;
                case 5:
                    viewAllContacts();
                    break;
                case 6:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addContact(Scanner scanner) {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact phone number: ");
        String phoneNO = scanner.nextLine();
        System.out.print("Enter contact email: ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNO, email);
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    private static void editContact(Scanner scanner) {
        System.out.print("Enter contact name to edit: ");
        String nameToEdit = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(nameToEdit)) {
                System.out.print("Enter new phone number: ");
                String newphoneNO = scanner.nextLine();
                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();

                contact.setphoneNO(newphoneNO);
                contact.setEmail(newEmail);
                System.out.println("Contact edited successfully.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    private static void deleteContact(Scanner scanner) {
        System.out.print("Enter contact name to delete: ");
        String nameToDelete = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(nameToDelete)) {
                contacts.remove(contact);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    private static void searchContacts(Scanner scanner) {
        System.out.print("Enter search term (name or email): ");
        String searchTerm = scanner.nextLine();

        System.out.println("\nSearch Results:");
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(searchTerm.toLowerCase())
                    || contact.getEmail().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println(contact);
                System.out.println();
            }
        }
    }

    private static void viewAllContacts() {
        System.out.println("\nAll Contacts:");
        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println();
        }
    }
}