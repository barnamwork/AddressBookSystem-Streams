package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {

    private static AddressBook addressBook = new AddressBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Address Book Program");

        while (true) {
            System.out.println("\n1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. View Contacts");
            System.out.println("5. Exit");

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
                    System.out.println("Thank You");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    private static void addContact() {

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

        ContactPerson person = new ContactPerson(
                firstName, lastName, address, city, state, zip, phone, email);

        addressBook.addContact(person);
        System.out.println("Contact Added Successfully!");
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

        boolean updated = addressBook.editContact(
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