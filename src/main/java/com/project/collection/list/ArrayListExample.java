package com.project.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {
    static void main() {
        List<Integer> list = new ArrayList<>();
        list.add(99);
        list.add(98);
        list.add(2);
        list.add(1);
        System.out.println(list);
        list.add(1, 22);
        System.out.println(list);
        list.set(2, 33);
        System.out.println(list);
        System.out.println(list.size() + " : size");
        list.remove(Integer.valueOf(1));
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.contains(2)+ " : contains 2");

        var l2 = Arrays.asList("Mon", "Tues");
//        l2.remove("Mon"); // error
//        l2.add("Th");  // error
        l2.set(1, "Sun");
        System.out.println(l2);

        var l3 = List.of(1,2,3);
//        l3.set(1, 1); // error
        System.out.println(l3);
        List<String> l4 = new ArrayList<>(l2);
        l4.add("Th");
        System.out.println(l4);

        List<Integer> l5 = new ArrayList<>(l3);
        l5.add(99);
        System.out.println(l5);
        l4.addAll(l2);
        System.out.println(l4);
        Object[] objs = l4.toArray();
        String[] strs = l4.toArray(new String[0]);
        System.out.println(objs);
        System.out.println(strs);
        Collections.sort(l4);
        System.out.println(l4);
        list.sort(null);
        System.out.println(list);
        list.removeAll(new ArrayList<>());

    }
}


/*
* List - Notes
*  - Collections works with non-Primitive Type
*  - Ordered, Duplicate & Index Based Access
*  - Arraylist - Dynamic Size, Ordered, Duplicate, Constant Random Access, O(n) insertion/deletion
*    - Internally it has Array of Object, initial default capacity - 10
*    - Add flow -> check capacity -> resize if necessary ( create new internal array of 1.5 times and copy all value ) -> add element
*    - Initial Default Capacity - 10, Growth Factor - 1.5, Copying Element - O(n)
*    - Remove flow by index -> check bound if index exist or not -> remove element and shift elements to the left to fill the gap -> reduce size by 1
*    - Remove with object -> it removes the first occurrence of that object
*    - removing the element does not reduce the internal array size even if it has been resized, if we want to reduce the size then we can use trimToSize()
*    - trimToSize() - it reduces the size of internal array
*    - Arrays.asList() - it return fixed sized list, where elements can not be inserted but replaced
*    - List.of() - it returns unmodifiable list, neither add/remove nor replace is allowed
*    - 0 based indexing
*    - Collections.sort and listObj.sort() - sorts the elements, listObj.sort requires comparator if null is passed natural order is used
*    - Time Complexity - Access by Index O(1), adding O(n) - shifting and resizing, removing O(n) - shifting, iteration O(n)
* */