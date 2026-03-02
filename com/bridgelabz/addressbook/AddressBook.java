package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBook {
    private final List<ContactPerson> contacts = new ArrayList<>();

    public void addContact(ContactPerson p) {
        if (p == null) return;
        contacts.add(p);
    }

    public Optional<ContactPerson> findByName(String firstName, String lastName) {
        return contacts.stream()
                .filter(c -> c.getFirstName().equalsIgnoreCase(firstName)
                        && c.getLastName().equalsIgnoreCase(lastName))
                .findFirst();
    }

    public boolean editContact(String firstName, String lastName, ContactPerson updated) {
        Optional<ContactPerson> opt = findByName(firstName, lastName);
        if (opt.isEmpty()) return false;
        ContactPerson c = opt.get();
        if (updated.getFirstName() != null && !updated.getFirstName().isBlank()) c.setFirstName(updated.getFirstName());
        if (updated.getLastName() != null && !updated.getLastName().isBlank()) c.setLastName(updated.getLastName());
        c.setAddress(updated.getAddress());
        c.setCity(updated.getCity());
        c.setState(updated.getState());
        c.setZip(updated.getZip());
        c.setPhoneNumber(updated.getPhoneNumber());
        c.setEmail(updated.getEmail());
        return true;
    }

    public List<ContactPerson> getAllContacts() {
        return new ArrayList<>(contacts);
    }
}