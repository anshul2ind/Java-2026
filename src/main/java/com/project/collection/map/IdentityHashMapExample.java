package com.project.collection.map;

import java.util.HashMap;
import java.util.IdentityHashMap;

public class IdentityHashMapExample {
    static void main() {
        String key1 = new String("key");
        String key2 = new String("key");
        var map = new HashMap<String, Integer>();

        System.out.println(System.identityHashCode(key1));
        System.out.println(System.identityHashCode(key2));
        System.out.println(key1.hashCode());
        System.out.println(key2.hashCode());

        // HashCode -> System.identityHashCode -> it uses Objects.hashCode even if hashCode method is overridden -> Objects.hashCode() returns value which does not change for lifetime of object and is generated lazily when requested first time
        // equal -> == ( compares the reference )
        var imap = new IdentityHashMap<String, Integer>();

        map.put(key1, 1);
        map.put(key2, 1);
        System.out.println(map);

        imap.put(key1, 1);
        imap.put(key2, 1);
        System.out.println(imap);
    }
}
