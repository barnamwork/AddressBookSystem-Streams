package com.bridgelabz.addressbook;

import java.util.Scanner;
import java.util.Optional;

public class AddressBookMain {
    private static final Scanner sc = new Scanner(System.in);
    private static final AddressBook book = new AddressBook();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program - UC2 Edit");
        while (true) {
            System.out.println("\n1) Add  2) Edit  3) List  4) Exit");
            System.out.print("Choice: ");
            String ch = sc.nextLine().trim();
            switch (ch) {
                case "1":
                    add();
                    break;
                case "2":
                    edit();
                    break;
                case "3":
                    book.getAllContacts().forEach(System.out::println);
                    break;
                case "4":
                    System.out.println("Thank you"); return;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    private static void add() {
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
        book.addContact(new ContactPerson(f, l, addr, city, state, zip, phone, email));
        System.out.println("Added.");
    }

    private static void edit() {
        System.out.print("First name of person to edit: ");
        String f = sc.nextLine().trim();
        System.out.print("Last name: ");
        String l = sc.nextLine().trim();
        Optional<ContactPerson> opt = book.findByName(f, l);
        if (opt.isEmpty()) { System.out.println("Not found"); return; }
        System.out.println("Enter updated details (leave blank to keep):");
        System.out.print("New First name: ");
        String nf = sc.nextLine().trim();
        System.out.print("New Last name: ");
        String nl = sc.nextLine().trim();
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
        ContactPerson updated = new ContactPerson(nf, nl, addr, city, state, zip, phone, email);
        boolean ok = book.editContact(f, l, updated);
        System.out.println(ok ? "Updated" : "Failed");
    }
}