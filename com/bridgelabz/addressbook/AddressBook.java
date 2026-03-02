package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBook {

    private List<ContactPerson> contacts = new ArrayList<>();

    // UC6 – Add Contact with Duplicate Check
    public boolean addContact(ContactPerson person) {

        boolean isDuplicate = contacts.stream()
                .anyMatch(existing -> existing.equals(person));

        if (isDuplicate) {
            return false;
        }
        contacts.add(person);
        return true;
    }

    // UC2 – Edit Contact
    public boolean editContact(String firstName, String lastName,
                               String address, String city,
                               String state, String zip,
                               String phone, String email) {

        Optional<ContactPerson> optionalPerson = contacts.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(firstName)
                        && p.getLastName().equalsIgnoreCase(lastName))
                .findFirst();

        if (optionalPerson.isPresent()) {
            ContactPerson person = optionalPerson.get();
            person.setAddress(address);
            person.setCity(city);
            person.setState(state);
            person.setZip(zip);
            person.setPhoneNumber(phone);
            person.setEmail(email);
            return true;
        }
        return false;
    }

    // UC3 – Delete Contact
    public boolean deleteContact(String firstName, String lastName) {
        return contacts.removeIf(p ->
                p.getFirstName().equalsIgnoreCase(firstName)
                        && p.getLastName().equalsIgnoreCase(lastName));
    }

    public List<ContactPerson> getAllContacts() {
        return contacts;
    }
}