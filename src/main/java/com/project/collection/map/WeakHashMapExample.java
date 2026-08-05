package com.project.collection.map;

import java.util.WeakHashMap;

public class WeakHashMapExample {
    static void main() {
        WeakHashMap<String, Phone> weakHashMap = new WeakHashMap<>();

        weakHashMap.put("key1", new Phone("Apple", "Iphone"));
        weakHashMap.put(new String("key2"), new Phone("Apple", "Iphone"));
        weakHashMap.put(new String("key3"), new Phone("Moto", "G"));
        System.out.println(weakHashMap);
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(weakHashMap);

    }
}

/*
* WeakHashMap - Notes
*   - It is stores the keys are WeakReference and when there is not Strong reference to the key then on next GC cycle that entry is removed from the map
*   - If using string literal are used for  keys then this will not work because GC never removes the String Literal as they are stored in String Pool
*   - Important information should not be stored here
*   - We can pass the capacity and load factor
*   - It extends AbstractMap
*  */
