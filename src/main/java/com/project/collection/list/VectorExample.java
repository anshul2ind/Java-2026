package com.project.collection.list;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class VectorExample {
    static void main() {
        Vector<Integer> vector = new Vector<>(3, 4);
        vector.add(1);
        vector.add(2);
        vector.add(3);
        System.out.println("Size : "+ vector.size());
        System.out.println("Capacity : "+ vector.capacity());
        vector.add(4);
        System.out.println("Size : "+ vector.size());
        System.out.println("Capacity : "+ vector.capacity());

        var v2 = new Vector<String>(Arrays.asList("Test", "Vector", "Cons"));
        v2.add(2, "Insert at 2");
        System.out.println(v2);
        v2.set(2, "Update at 2");
        System.out.println(v2);
        v2.remove(2);
        System.out.println(v2);
        v2.remove("Test");
        System.out.println(v2);
        System.out.println("IsEmpty : " + v2.isEmpty());
        System.out.println("Contains(Cons) : " + v2.contains("Cons"));
        System.out.println("Get(1) : " + v2.get(1));
        v2.clear();
        System.out.println(v2);
        System.out.println("IsEmpty : " + v2.isEmpty());

        var v3 = new Vector<Integer>();
        var list = new ArrayList<Integer>();

        Runnable r1 = () -> {
            for(int i = 0 ; i < 1000 ; i++) {
                v3.add(i);
                list.add(i);

            }
        };

        var t1 = new Thread(r1);
        var t2 = new Thread(r1);
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("v3 size : "+v3.size());
        System.out.println("list size : "+list.size());


    }
}

/*
* Vector - Notes
*  - It is part of java.util package and is one the legacy class that implements List interface
*  - It was introduced in JDK 1.0 and is thread safe because all the methods are synchronized
*  - Now it is part of collection framework
*  - Due its synchronization overhead - (slower or takes extra memory), modern alternatives are suggested to use - ArrayList for single thread usecase
*  - Vector are still useful for multithreaded env where thread safety is concern
*  - Features - Dynamic Array, Synchronized, Resizing, Random Access & Legacy Class
*  - Default capacity - 10 and can be updated by constructor argument
*  - Default capacity increment is 2X of current capacity, it can be updated by the number by which capacity should be increased
*    - passing 2nd arg to constructor uses it as incrementBy number passing 4, everytime of resizing capacity will increase by 4
*  - Similar to ArrayList and LinkedList - we can pass collection to its constructor as arg
*  - Similar to ArraayList - Internally it maintains an Array and size of array grows whenever more than capacity elements needs to be added and by default internal array is increase 2X of current capacity and copy operation is performed to new Array
*  - O( ) - Read - O(1), Add/Remove -> O(n)
*  - Synchronization adds performance overhead in single threaded env because it add locking and unlocking cost
*  - Modern alternative for multi-threaded env -> CopyOnWriteArrayList & ConcurrentHashMap from java.util.concorrent package
* */