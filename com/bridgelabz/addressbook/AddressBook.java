package com.bridgelabz.addressbook;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressBook {

    private List<ContactPerson> contacts = new ArrayList<>();

    // UC1 – Add Contact
    public void addContact(ContactPerson person) {
        contacts.add(person);
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