package com.bridgelabz.addressbook;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    private static Scanner scanner = new Scanner(System.in);
    private static AddressBookSystem system = new AddressBookSystem();
    private static AddressBook currentAddressBook;
    private static String currentBookName;

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        system.createAddressBook("Default");
        currentBookName = "Default";
        currentAddressBook = system.getAddressBook(currentBookName);

        while (true) {

            System.out.println("\nCurrent Address Book: " + currentBookName);
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Create Address Book");
            System.out.println("6. Switch Address Book");
            System.out.println("7. Search by City/State (UC7)");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addContact();
                    break;
                case 2:
                    editContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    viewContacts();
                    break;
                case 5:
                    createAddressBook();
                    break;
                case 6:
                    switchAddressBook();
                    break;
                case 7:
                    searchPerson();
                    break;
                case 8:
                    System.out.println("Thank You");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private static void searchPerson() {

        System.out.println("1. Search by City");
        System.out.println("2. Search by State");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.print("Enter City: ");
            String city = scanner.nextLine();

            Map<String, List<ContactPerson>> result =
                    system.searchByCity(city);

            displaySearchResult(result);

        } else if (choice == 2) {
            System.out.print("Enter State: ");
            String state = scanner.nextLine();

            Map<String, List<ContactPerson>> result =
                    system.searchByState(state);

            displaySearchResult(result);
        }
    }

    private static void displaySearchResult(
            Map<String, List<ContactPerson>> result) {

        boolean found = false;

        for (Map.Entry<String, List<ContactPerson>> entry : result.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                found = true;
                System.out.println("\nAddress Book: " + entry.getKey());
                entry.getValue().forEach(System.out::println);
            }
        }

        if (!found) {
            System.out.println("No matching contacts found.");
        }
    }

    private static void addContact() {
        ContactPerson person = readContactDetails();
        boolean added = currentAddressBook.addContact(person);

        if (added)
            System.out.println("Contact Added Successfully!");
        else
            System.out.println("Duplicate Contact Not Allowed!");
    }

    private static void editContact() {
        System.out.print("First Name: ");
        String fn = scanner.nextLine();
        System.out.print("Last Name: ");
        String ln = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("Zip: ");
        String zip = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        currentAddressBook.editContact(
                fn, ln, address, city, state, zip, phone, email);
    }

    private static void deleteContact() {
        System.out.print("First Name: ");
        String fn = scanner.nextLine();
        System.out.print("Last Name: ");
        String ln = scanner.nextLine();
        currentAddressBook.deleteContact(fn, ln);
    }

    private static void viewContacts() {
        currentAddressBook.getAllContacts().forEach(System.out::println);
    }

    private static void createAddressBook() {
        System.out.print("Enter Address Book Name: ");
        String name = scanner.nextLine();
        system.createAddressBook(name);
    }

    private static void switchAddressBook() {
        system.getAllAddressBookNames().forEach(System.out::println);
        System.out.print("Enter Address Book Name: ");
        currentBookName = scanner.nextLine();
        currentAddressBook = system.getAddressBook(currentBookName);
    }

    private static ContactPerson readContactDetails() {

        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("Zip: ");
        String zip = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new ContactPerson(
                firstName, lastName, address, city, state, zip, phone, email);
    }
}