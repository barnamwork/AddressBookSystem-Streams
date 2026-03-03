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
            System.out.println("7. Search by City/State");
            System.out.println("8. View Persons by City/State");
            System.out.println("9. Count Persons by City/State (UC9)");
            System.out.println("10. Exit");

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
                    viewGroupedPersons();
                    break;
                case 9:
                    countPersons();
                    break;
                case 10:
                    System.out.println("Thank You");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private static void countPersons() {

        System.out.println("1. Count by City");
        System.out.println("2. Count by State");

        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {

            Map<String, Long> cityCount = system.countByCity();

            cityCount.forEach((city, count) ->
                    System.out.println("City: " + city + " -> Count: " + count));

        } else if (choice == 2) {

            Map<String, Long> stateCount = system.countByState();

            stateCount.forEach((state, count) ->
                    System.out.println("State: " + state + " -> Count: " + count));
        }
    }

    // --- Existing Methods (same as UC8) ---

    private static void addContact() {
        ContactPerson person = readContactDetails();
        currentAddressBook.addContact(person);
    }

    private static void editContact() { }

    private static void deleteContact() { }

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

    private static void searchPerson() { }

    private static void viewGroupedPersons() { }

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