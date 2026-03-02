package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    private static Scanner scanner = new Scanner(System.in);
    private static AddressBookSystem system = new AddressBookSystem();
    private static AddressBook currentAddressBook;

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        // Create default address book
        system.createAddressBook("Default");
        currentAddressBook = system.getAddressBook("Default");

        while (true) {

            System.out.println("\nCurrent Address Book: Default");
            System.out.println("1. Add Contact");
            System.out.println("2. Add Multiple Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. View Contacts");
            System.out.println("6. Create Address Book");
            System.out.println("7. Switch Address Book");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    addSingleContact();
                    break;

                case 2:
                    addMultipleContacts();
                    break;

                case 3:
                    editContact();
                    break;

                case 4:
                    deleteContact();
                    break;

                case 5:
                    viewContacts();
                    break;

                case 6:
                    createAddressBook();
                    break;

                case 7:
                    switchAddressBook();
                    break;

                case 8:
                    System.out.println("Thank You");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private static void addSingleContact() {
        ContactPerson person = readContactDetails();
        currentAddressBook.addContact(person);
        System.out.println("Contact Added Successfully!");
    }

    private static void addMultipleContacts() {

        System.out.print("How many contacts do you want to add? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            System.out.println("\nEnter details for Contact " + i);
            ContactPerson person = readContactDetails();
            currentAddressBook.addContact(person);
        }
        System.out.println("All Contacts Added!");
    }

    private static void editContact() {

        System.out.print("Enter First Name to Edit: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name to Edit: ");
        String lastName = scanner.nextLine();

        System.out.println("Enter Updated Details");

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

        boolean updated = currentAddressBook.editContact(
                firstName, lastName, address, city, state, zip, phone, email);

        if (updated)
            System.out.println("Contact Updated Successfully!");
        else
            System.out.println("Contact Not Found!");
    }

    private static void deleteContact() {

        System.out.print("Enter First Name to Delete: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name to Delete: ");
        String lastName = scanner.nextLine();

        boolean deleted = currentAddressBook.deleteContact(firstName, lastName);

        if (deleted)
            System.out.println("Contact Deleted Successfully!");
        else
            System.out.println("Contact Not Found!");
    }

    private static void viewContacts() {
        System.out.println("\n---- Contact List ----");
        currentAddressBook.getAllContacts().forEach(System.out::println);
    }

    private static void createAddressBook() {

        System.out.print("Enter Address Book Name: ");
        String name = scanner.nextLine();

        boolean created = system.createAddressBook(name);

        if (created)
            System.out.println("Address Book Created Successfully!");
        else
            System.out.println("Address Book Already Exists!");
    }

    private static void switchAddressBook() {

        System.out.println("Available Address Books:");
        system.getAllAddressBookNames().forEach(System.out::println);

        System.out.print("Enter Address Book Name to Switch: ");
        String name = scanner.nextLine();

        AddressBook selected = system.getAddressBook(name);

        if (selected != null) {
            currentAddressBook = selected;
            System.out.println("Switched to Address Book: " + name);
        } else {
            System.out.println("Address Book Not Found!");
        }
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