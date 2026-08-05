package com.project.collection.list;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListExample {

    static void main() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(22);
        list.add(2);
        list.add(56);

        list.add(3, 33);

        list.get(2); // O(n)
        list.addLast(99); // O(1)
        list.addFirst(1); // O(1)

        System.out.println(list);
        list.removeIf(x -> x % 2 == 0);
        System.out.println(list);
        list.getLast();
        list.getFirst();
        list.removeFirst();
        list.removeLast();
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        LinkedList<String> animals = new LinkedList<>(Arrays.asList("Dog", "Cat", "Elephant"));
        System.out.println(animals);
        LinkedList<String> animalsToRemove = new LinkedList<>(Arrays.asList("Dog", "Elephant"));
        animals.removeAll(animalsToRemove);
        System.out.println(animals);


    }
}

/*
* LL - Notes
*  - Stores as collection of nodes in doubly linked list
*  - Each node has data element and Pointers - previous & next pointer ( 2 Pointers )
*  - Insertions & Deletions -> Better for frequent insertions and deletion as it does not require the shifting of elements as compare to ArrayList
*  - Random Access -> Slower as compare to ArrayList as need to traverse the LL to desired index
*  - Memory Overhead -> Each node requires extra memory for Pointers
* */