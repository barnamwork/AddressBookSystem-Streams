package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private final List<com.bridgelabz.addressbook.ContactPerson> contacts = new ArrayList<>();

    public void addContact(ContactPerson p) {
        if (p == null) return;
        contacts.add(p);
    }

    public List<ContactPerson> getAllContacts() {
        return new ArrayList<>(contacts);
    }
}