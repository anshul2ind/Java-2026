package com.project.collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    static void main() {
        var linkedHashMap = new LinkedHashMap<String, String>();
        var map = new HashMap <String, String>();
        map.put("D", "1");
        map.put("B", "1");
        map.put("A", "1");
        map.put("C", "1");

        linkedHashMap.put("D", "1");
        linkedHashMap.put("B", "1");
        linkedHashMap.put("A", "1");
        linkedHashMap.put("C", "1");

        System.out.println(map);
        System.out.println(linkedHashMap);

       for(var entry: map.entrySet()) {
           System.out.print(entry.getKey() + " , ");
       }

        System.out.println("\n----------");

        for(var entry: linkedHashMap.entrySet()) {
            System.out.print(entry.getKey() + " , ");
        }

    }
}

/*
* LinkedHashMap - Notes
*   - It extends HashMap
*   - It also maintains Double LinkedList
*   - we can pass initial capacity, load factor same as Hashmap and inaddition to these 2, 3rd arg is accessOrder
*   - accessOrder - By default false, with false value intersion order is maintained but if set true; any access via get or put will send that entry to last of LL
*   - Extra memory is consumed because of LL
*   - It is not thread safe same as HashMap
*   - It is used when order matters - either insertion or LRU
*   - firstEntry & lastEntry methods are available in LinkedHashMap
*   - removeEldestEntry : this method is invoked after put or putAll for every new entry
* */