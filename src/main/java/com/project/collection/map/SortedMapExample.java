package com.project.collection.map;

import java.util.Comparator;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapExample {
    static void main() {

        SortedMap<Integer, String> map = new TreeMap<>(Comparator.reverseOrder());
        map.put(9, "Dev");
        map.put(12, "Sre");
        map.put(20, "DBA");
        map.put(7, "QA");
        map.put(3, "Jr");

        System.out.println(map);
        for(var entry: map.entrySet()) {
            System.out.print(entry.getKey() + " , ");
        }
        System.out.println("");
        System.out.println("map.firstKey() : " + map.firstKey());
        System.out.println("map.lastKey() : " + map.lastKey());
        System.out.println("map.headMap(9) : " + map.headMap(9)); // toKey is not included
        System.out.println("map.tailMap(9) : " + map.tailMap(9)); // fromKey is included
        System.out.println("map.subMap(12, 7) : " + map.subMap(12, 7)); // fromKey is included

        NavigableMap<Integer, String> navigableMap = new TreeMap<>();
        navigableMap.put(1, "One");
        navigableMap.put(5 , "Five");
        navigableMap.put(3, "Three");

        System.out.println(navigableMap);
        System.out.println("map.higherKey(0) : " + navigableMap.higherKey(0)); // Return higher than the passed value but least, even if same key is present then next key is returned
        System.out.println("map.higherKey(1) : " + navigableMap.higherKey(1));
        System.out.println("map.lowerKey(0) : " + navigableMap.lowerKey(0)); // Return lower than the passed value but highest, even if same key is present then next key is returned
        System.out.println("map.lowerKey(4) : " + navigableMap.lowerKey(4));
        System.out.println("map.higherEntry(1) : " + navigableMap.higherEntry(1));
        System.out.println("map.lowerEntry(4) : " + navigableMap.lowerEntry(4));
        System.out.println("navigableMap.descendingMap() : \n" + navigableMap.descendingMap());
        System.out.println("map.ceilingKey(1) : " + navigableMap.ceilingKey(1)); // Higher than or equal to passed value






    }
}

/*
*  SortedMap - Notes
*   - SortedMap is an interface and TreeMap implements SortedMap
*   - SortedMap extends Map interface and provide some extra functionalities which make sure entries are sorted based on key either by natural order ( Comparable ) or by custom Comparator
*   - Provides Method to fetch the data in range
*   - firstKey - Returns first key
*   - lastKey - Returns last key
*   - headMap(toKey) - Returns the sub-map from head/first-key to the toKey and toKey is excluded
*   - tailMap(fromKey) - Similar to headMap, returns the sub-map but from the fromKey to tail/last-key  and fromKey is included
*   - subMap(fromKey, toKey) - Returns the sub-map from fromKey to toKey, and fromKey is included but toKey is excluded
*   - TreeMap
*       - Null keys are not allowed
*       - Accepts comparator as constructor argument
*       - Put/Get/ContainsKey are O( log n ) operation and ContainsValue is O(n)
*       - It maintains Self Balanced Binary Search Tree ( Red Black Tree ) for keys that is Put/Get are O ( log n ) not O ( 1 )
*       - ForEach Traversal or toString both return stored data
*   - SortedMap (I) - NavigableMap (I) - TreeMap (C)
*   - NavigableMap
*       - Provides more powerful navigation options such as finding the closest matching key or retrieving the map in reverse order
*       - higherKey(key) - Return higher than the passed value but least, even if same key is present then next key is returned
*       - lowerKey(key) - Return lower than the passed value but highest, even if same key is present then next key is returned
*       - higherEntry(key) - Same as higherKey but returns Entry
*       - lowerEntry(key) - Same as lowerKey but returns Entry
*       - descendingMap - returns the map in descending order
*       - descendingKeySet - returns key set in descending order
*
*
*
*
*
* */