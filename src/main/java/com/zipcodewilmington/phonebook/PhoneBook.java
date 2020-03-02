package com.zipcodewilmington.phonebook;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String, List<String>> test = new LinkedHashMap<>();
    List<String> numbers = new ArrayList<>();
    public PhoneBook(Map<String, List<String>> map) {
        this.test=map;
    }

    public PhoneBook() {}

    public void add(String name, String phoneNumber) {
        numbers.add(phoneNumber);
        test.put(name, numbers);

    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> allNumbers = Arrays.asList(phoneNumbers);
        test.put(name,allNumbers);
    }

    public void remove(String name) {
        test.remove(name);
    }

    public Boolean hasEntry(String name) {

            if(test.containsValue(name) || numbers.contains(name)){
                return true;
            }


        return false;
    }

    public List<String> lookup(String name) {
        return test.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String,List<String>> elements: test.entrySet()) {

            if(elements.getValue().contains(phoneNumber)){
                return elements.getKey();
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        List<String> answer = new ArrayList<String>(test.keySet());

        return answer;
    }

    public Map<String, List<String>> getMap() {
        return test;
    }
}
