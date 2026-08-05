package com.project.collection.list;

import java.util.LinkedList;
import java.util.Stack;

public class VectorStackExample {

    static void main() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println("stack.pop() : "+ stack.pop());
        System.out.println(stack);
        System.out.println("stack.peek() : "+ stack.peek());
        System.out.println("stack.search(1) : "+ stack.search(1));

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        System.out.println(linkedList);
        System.out.println("linkedList.removeLast() : "+ linkedList.removeLast());
        System.out.println(linkedList);
        System.out.println("linkedList.getLast() : "+ linkedList.getLast());
        System.out.println("stack.indexOf(1) : "+ stack.indexOf(1));

    }
}

/*
* Stack - Notes
*  - LIFO - Last In First In
*  - Stack implements Vector that is why it is synchronized
*  - It has Push, Pop, Peek and Search + all the methods of Vector class
*  - Search - it search for item from Top and returns the index of the item and index start from 1
* */