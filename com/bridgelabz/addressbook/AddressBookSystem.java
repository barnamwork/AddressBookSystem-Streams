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

    // UC7 – Search by City across ALL address books
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

    // UC7 – Search by State across ALL address books
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
}