package com.project.collection.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {

    static void main() {
//        ArrayList<String> aList = new ArrayList<>(List.of("a", "b", "c", "d"));
        CopyOnWriteArrayList<String> aList = new CopyOnWriteArrayList<>(List.of("a", "b", "c", "d"));
        for(var ch: aList) {
            System.out.println(ch);
                aList.add(ch+" : updated");
                System.out.println(aList.hashCode());
        }
        System.out.println(aList);


        var l2 = new CopyOnWriteArrayList<String>(List.of("A", "B", "C", "D", "E"));
    }
}

/*
* CopyOnWriteArrayListExample - Notes
* - CopyOnWrite means whenever write operation is performed ( adding, removing ) instead of directly modifying the internal array a new copy of array is created and modifications applied to it
*  - This ensures that iterators which are reading the data are unaffected while list is modified
*  - When an iterator is created it gets the reference to current array as immutable snapshot and iterator keeps iterating over snapshot and modification happens on new array
*  - Modification methods are synchronized make them thread safe for modification
*  - Read operations ( Iteration ) - Fast and Direct since they happen on stable copy without interference from modification
*  - Write operation - new copy of list is created for every modification
*                    - the reference to the list is then updated so that subsequent read use the new list
*  - It can work as Stack same as LinkedList as it has AddLast/RemvoeLast etc methods
*  - Internally it uses Volatile keyword which makes sure that threads do not cache the array reference either in CPU Registers or local cached instead it forces them to read/write the value of variable from Main Memory
*  - The Volatile keywords helps in multi-thread env to every reader thread gets the latest value not cached one
*  - Uses - one writer and many reader
*  - For many writer use case - synchronization, locks or atomic variable should be used
*
* */