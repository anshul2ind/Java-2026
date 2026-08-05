package com.project.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HashMapExample {
    static void main() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(5, "a");
        map.put(4, "a");
        map.put(3, "b");
        map.put(2, "c");
        map.put(1, "d");
        map.put(null, "not null");
        map.put(null, "null");
        map.put(11, null);
        map.put(12, null);

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for(Map.Entry<Integer, String> entry: entries) {
            System.out.println("entry.getKey() : " + entry.getKey() + ", entry.getValue(): " + entry.getValue());
           if ( entry.getValue() != null)
           {
               entry.setValue(entry.getValue().toUpperCase());
           }
            System.out.println("entry.getKey() : " + entry.getKey() + ", entry.getValue(): " + entry.getValue());
        }

        System.out.println(map);
        System.out.println("map.remove(1) : " + map.remove(1));
        System.out.println("map.remove(2, c) : " + map.remove(2, "c"));
        System.out.println(map);

        var p1 = new Person(1, "John");
        var p2 = new Person(2, "Doe");
        var p3 = new Person(1, "John");

        var personMap = new HashMap<Person, String>();
        personMap.put(p1, "DEV");
        personMap.put(p2, "SRE");
        personMap.put(p3, "ARC");

        System.out.println(personMap);


    }
}

class Person {
    private int id;
    private String name;
    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

//    used in hash code calculation for index identification in the array
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

// use for comparisons of the key in a bucket
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if (obj == null) {
            return false;
        }

        if(getClass() != obj.getClass()) {
            return false;
        }

        Person other = (Person) obj;
        return this.id == other.id && Objects.equals(this.name, other.name);
    }
    @Override
    public String toString() {
        return "{ id: "+ id + " , name: " + name + " }";
    }
}

/*
* Map - Notes
*  - Map interface does not extend Collection interface
*  - Key-Value - Map stores data in key-value pair
*  - Unique key - No 2 keys can be same
*  - One Value per key - each key maps to single value
*  - Order - LinkedHashMap - insertion order, TreeMap - natural order, HashMap - no order
*
* HashMap - Notes
*  - get(key) - if key is not present then null is returned
*  - getOrDefault(key, defaultValue) - if key is not present then defaultValue is returned
*  - putIfAbsent(key, value) - put only if key is already not present
*  - putAll - for multiple entries
*  - containsKey(key) - returns boolean value for key existence
*  - containsValue(value) - returns boolean value for value existence
*  - remove(key) - removes by key, returns value of remove entry
*  - remove(key, value) - removes by key and value, returns boolean
*  - keySet() - returns the Set of keys
*  - entrySet() - returns Set of Map.Entry<key,value>
*  - entry.getKey - Get key for the entry
*  - entry.getValue - Get value for the entry
*  - entry.setValue - Set value for the entry
*  - Key Characteristic
*    - No Order - Does not maintain any order
*    - Allow null keys and values - one null key and multiple null values
*    - Not synchronized - Not thread safe, requires external synchronization if used in mutli-threaded context
*    - Performance - Offers constant time O(1) performance for basic operation ( get, put ), assuming hash function disperses the element properly
*  - Internal Structure
*    - Basic Components - Key, value , bucket, hash function
*    - bucket -> buckets stores the key,value pair, think of buckets as a cells in list( array )
*      - HashMap internally uses Array to store the key,value pair in an index
*    - Hash function -> map the key to an index i.e. converts the key into array index ( bucket location )
*      - Its an algorithm that takes an input ( key ) and returns a fixed size string of bytes, typically a numerical value. The output is known as Hash Value, Hash Code, or simply Hash
*      - Primary purpose of a Hash Function is to map data of arbitrary size into data of fixed size
*      - Deterministic -> Same input will always produce same output
*      - Fixed Output Size -> Regardless of input size, hash code has consistent size e.g. 32 bit or 64 bit
*      - Efficient computation -> the hash function should compute the hash quickly - Optimized
*      - Same Output -> 2 or more keys can have same output hash-code and it is called collision and it is because of infinite number of input but output is from finite number of values
*      - Default array size is 16
*    - Put method Working
*       - Each Array index stores the linked list - node structure { final int hash; final K key; V value; Node<K, V> next; }
*       - Step 1 - Hashing the key -> function generates the unique hash code ( an integer number ), this hash code helps in determining where the key-value will be stored in array ( called a "bucket array" )
*       - Step 2 - Calculating the index -> hashCode % arraySize, the index decides which bucket will hold key-value pair
*       - Step 3 - Storing in the bucket -> key-value pair stored in the bucket at the calculated index, each bucket can hold multiple key-values ( Collision handling mechanism )
*       - Step 4 - it the bucket(index) already has some key-value then key new value is compared against stored key-value using .equals method to identify whether it is new entry or update to existing entry
*    - Get method Working
*       - Step 1 - Hashing the key -> Step 2 - Calculating the index -> Searching in the bucket -> by the key in the linked list of that index
*    - Collision Handling in Hashmap
*       - if multiple key,value pair map to same bucket then they are stored in a linked list ( balance tree after Java 8 - Balanced Binary Search Tree - Red Black Tree) inside the bucket
*       - Treefication - After Java 8 when the size of Linked List in a bucket increase by certain threshold ( by default 8 ) it Linked List is converted to Balanced Binary Search Tree ( Self balancing binary search tree -> balanced after insertion and deletion) now time complexity changes from O(n) to O(log n)
*       - when a key,value pair is retrieved, the Hashmap traverse the Linked List checking each, checking each key until it finds the match
*       - .equals -> equals method from Object class is used in case of collision to compare the keys
*    - HashMap Resizing ( Rehashing )
*       - default internal array size 16 and load factor 0.75, we can changes these values from constructor argument
*       - when the size of Hashmap increase more than array size * load factor , the resizing and rehasing is performed
*       - array size is doubled
*       - once new array is created with double the capacity, key,values from previous array are rehashed because of size change will result in different index
*       - this resizing makes sure that read/write performance of HashMap is not degraded
*       - single bucked storing multiple key-value will make time complexity from O(1) to O(n) or O(log n)
*   - Time Complexity
*       - Constant time O(n) for basic operations - get/put (assuming no collision), incase of collision it can degrade to O(n) or Java 8 ( more than 8 elements ) O(log n) where n is the number of element in the bucket
*       - Put/Get/Remove/ContainsKey -> O(1) -> O(n) -> O( log n) ( n number of elements in the bucket
*       - ContainsValue -> O(n) -> it traverse all the entries
*       - siz()/isEmpty() -> O(1) -> return stored size value
*       -
* */
