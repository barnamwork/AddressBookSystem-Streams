package com.bridgelabz.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBookSystem {

    private Map<String, AddressBook> addressBookMap = new HashMap<>();

    public boolean createAddressBook(String name) {
        if (addressBookMap.containsKey(name)) {
            return false;
        }
        addressBookMap.put(name, new AddressBook());
        return true;
    }

    public AddressBook getAddressBook(String name) {
        return addressBookMap.get(name);
    }

    public Set<String> getAllAddressBookNames() {
        return addressBookMap.keySet();
    }

    // -------- UC7 --------

    public Map<String, List<ContactPerson>> searchByCity(String city) {
        return addressBookMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getAllContacts().stream()
                                .filter(p -> p.getCity() != null &&
                                        p.getCity().equalsIgnoreCase(city))
                                .collect(Collectors.toList())
                ));
    }

    public Map<String, List<ContactPerson>> searchByState(String state) {
        return addressBookMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getAllContacts().stream()
                                .filter(p -> p.getState() != null &&
                                        p.getState().equalsIgnoreCase(state))
                                .collect(Collectors.toList())
                ));
    }

    // -------- UC8 --------

    public Map<String, List<ContactPerson>> viewPersonsByCity() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getAllContacts().stream())
                .filter(p -> p.getCity() != null)
                .collect(Collectors.groupingBy(ContactPerson::getCity));
    }

    public Map<String, List<ContactPerson>> viewPersonsByState() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getAllContacts().stream())
                .filter(p -> p.getState() != null)
                .collect(Collectors.groupingBy(ContactPerson::getState));
    }

    // -------- UC9 --------

    public Map<String, Long> countByCity() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getAllContacts().stream())
                .filter(p -> p.getCity() != null)
                .collect(Collectors.groupingBy(
                        ContactPerson::getCity,
                        Collectors.counting()
                ));
    }

    public Map<String, Long> countByState() {
        return addressBookMap.values().stream()
                .flatMap(book -> book.getAllContacts().stream())
                .filter(p -> p.getState() != null)
                .collect(Collectors.groupingBy(
                        ContactPerson::getState,
                        Collectors.counting()
                ));
    }
}