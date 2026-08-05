package com.project.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheExample {
    static void main() {
        var cache = new LRUCache<String, String>(3);
        cache.put("C++", "Functional");
        cache.put("C", "Functional");
        cache.put("Java", "OOPS");
        System.out.println(cache);
        cache.get("C");
        System.out.println(cache.lastEntry());
        cache.put("JS", "Fun");
        System.out.println(cache);
        System.out.println(cache.lastEntry());

        cache.putAll(Map.of("1", "1", "2", "2", "3", "3", "4", "4"));
        System.out.println(cache);

    }
}

class LRUCache<K, V> extends LinkedHashMap<K, V> {

    int capacity;

    LRUCache(int capacity) {
        super(16, .75f, true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
        var res =  size() > capacity;
       if(res) {
           System.out.println("removeEldestEntry : " + entry.getKey());
       }
        return res;
    }
}