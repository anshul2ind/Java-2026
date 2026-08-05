package com.project.collection.map;

import java.lang.ref.WeakReference;
import java.util.concurrent.ThreadLocalRandom;

public class WeakReferenceExample {
    static void main() {
        Phone phone = new Phone("Apple", "16 pro");
        WeakReference<Phone> phoneWeakReference = new WeakReference<Phone>(new Phone("Micromax", "Canvas 2"));
        System.out.println(phone);
        System.out.println(phoneWeakReference.get());
        System.gc();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {

        }
        System.out.println(phone);
        System.out.println(phoneWeakReference.get());
    }
}

class Phone{
    private String brand;
    private String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
/*
* WeakReference - Notes
*   - If objects is only referenced by WeakReference are removed from the Heap on next GC cycle
*   - if an object is only reachable by WeekReference then GC is allowed the reclaim the object on next GC cycle, JVM is free to collect it during next GC cycle
*   - part of java.lang.ref package
*   - It can be used with caching if object is deleted then it will be a cache miss and actual data can be fetched from the server
* */
