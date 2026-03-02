package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    private static AddressBook addressBook = new AddressBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Add Multiple Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. View Contacts");
            System.out.println("6. Exit");

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
                    System.out.println("Thank You");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // UC1 – Single Contact
    private static void addSingleContact() {
        ContactPerson person = readContactDetails();
        addressBook.addContact(person);
        System.out.println("Contact Added Successfully!");
    }

    // UC4 – Multiple Contacts
    private static void addMultipleContacts() {

        System.out.print("How many contacts do you want to add? ");
        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= count; i++) {
            System.out.println("\nEnter details for Contact " + i);
            ContactPerson person = readContactDetails();
            addressBook.addContact(person);
            System.out.println("Contact " + i + " Added!");
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

    // UC2 – Edit
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

        boolean updated = addressBook.editContact(
                firstName, lastName, address, city, state, zip, phone, email);

        if (updated)
            System.out.println("Contact Updated Successfully!");
        else
            System.out.println("Contact Not Found!");
    }

    // UC3 – Delete
    private static void deleteContact() {

        System.out.print("Enter First Name to Delete: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter Last Name to Delete: ");
        String lastName = scanner.nextLine();

        boolean deleted = addressBook.deleteContact(firstName, lastName);

        if (deleted)
            System.out.println("Contact Deleted Successfully!");
        else
            System.out.println("Contact Not Found!");
    }

    private static void viewContacts() {
        System.out.println("\n---- Contact List ----");
        addressBook.getAllContacts().forEach(System.out::println);
    }
}