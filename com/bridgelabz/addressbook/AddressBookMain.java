package com.bridgelabz.addressbook;

import java.util.Scanner;

public class AddressBookMain {
    private static final Scanner sc = new Scanner(System.in);
    private static final AddressBook book = new AddressBook();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program");
        System.out.println("UC1: Add a contact");
        System.out.print("First name: ");
        String f = sc.nextLine().trim();
        System.out.print("Last name: ");
        String l = sc.nextLine().trim();
        System.out.print("Address: ");
        String addr = sc.nextLine().trim();
        System.out.print("City: ");
        String city = sc.nextLine().trim();
        System.out.print("State: ");
        String state = sc.nextLine().trim();
        System.out.print("Zip: ");
        String zip = sc.nextLine().trim();
        System.out.print("Phone: ");
        String phone = sc.nextLine().trim();
        System.out.print("Email: ");
        String email = sc.nextLine().trim();

        ContactPerson p = new ContactPerson(f, l, addr, city, state, zip, phone, email);
        book.addContact(p);

        System.out.println("Contact added. Current contacts:");
        book.getAllContacts().forEach(System.out::println);
    }
}