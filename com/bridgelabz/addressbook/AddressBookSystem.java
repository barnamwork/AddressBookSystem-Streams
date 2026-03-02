package com.bridgelabz.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
}