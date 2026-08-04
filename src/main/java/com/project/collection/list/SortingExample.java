package com.project.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortingExample {
    static void main() {
        var list = new ArrayList<Integer>();
        list.add(5);
        list.add(1);
        list.add(9);
        list.add(2);
        var list2  = new ArrayList<>(list);
        list.sort(null);
        System.out.println(list);
        list2.sort(new IntegerComparator());
        System.out.println(list2);

        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        list2.sort(new IntegerComparator().reversed());
        System.out.println(list2);

        var strlist = Arrays.asList("banana", "apple", "date");
        strlist.sort(new StringLengthComparator());
        var strList2 = Arrays.asList("banana", "apple", "date");
        System.out.println(strlist);
        strList2.sort((a, b) -> a.length() - b.length());
        System.out.println(strList2);
        strlist.sort(new StringLengthComparator().reversed());
        strList2.sort((a, b) -> b.length() - a.length());
        System.out.println(strlist);
        System.out.println(strList2);

        var studList = new ArrayList<Student>();
        studList.add(new Student("Shyam", 4.3));
        studList.add(new Student("Bob", 3.5));
        studList.add(new Student("Ram", 4.3));
        studList.add(new Student("Charlie", 2.8));
        var studList2 = new ArrayList<Student>(studList);

        studList.sort((a, b) -> {
            var diff = a.getGpa() - b.getGpa();
            if(diff < 0) {
                return -1;
            } else if(diff > 0) {
                return 1;
            } else {
                return a.getName().compareTo(b.getName());
            }
        });

        Comparator<Student> gpaComparator =  Comparator.comparing(Student::getGpa).thenComparing(Student::getName);
//        Comparator<Student> gpaComparator =  Comparator.comparing(Student::getGpa).reversed();
       studList2.sort(gpaComparator);

        System.out.println(studList);
        System.out.println(studList2);


    }
}

class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}


class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}



/*
* Comparator - Notes
*  - It's a functional interface, i.e. we can also use lambda expression inplace of Class Implementation
*  - It has compare method which accepts 2 args
*  - returned value of compare method determine the relative order of the pair, and it should be integer only not double/float
*  - Negative then order is o1, o2
*  - Zero they are same
*  - Positive then order is o2, o1
*  - it is like o1 is more than o2 relationship with difference degree ex - 5,3 -> 5-3 -> 2, that means order is 3, 5 for accessing
*  - Comparator.comparing can be used to create the comparator by individual getter of the class and can be chanined as well with .reversed .andThan
* */