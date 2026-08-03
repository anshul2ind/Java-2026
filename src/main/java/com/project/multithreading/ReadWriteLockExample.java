package com.project.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    static void main() {
        final var counter = new ReadWriteCounter();
        Runnable writeAble = () -> {
            for(int i = 0; i < 10; i++) {
                counter.increment();
                System.out.println(Thread.currentThread().getName() + " : increment");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }
            }
        };

        Runnable readAble = () -> {
            for(int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+ " :- "+ counter.get());

                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {

                }

            }
        };

        var t1 = new Thread(writeAble, "T1");
        var t2 = new Thread(readAble, "T2");
        var t3 = new Thread(readAble, "T2");

        t1.start();
        t2.start();
        t3.start();
    }
}


class ReadWriteCounter {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(false);
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    private int count = 0;

    public void increment() {
       try {
           writeLock.lock();
           count++;
       } catch (Exception e) {

       } finally {
           writeLock.unlock();
       }
    }

    public int get() {
        try {
            readLock.lock();
        } catch (Exception e) {

        } finally {
            readLock.unlock();
            return count;
        }
    }
}

/*
* Read Write Lock - Notes
* Multiple thread can acquire read lock if there is no write lock
* write lock can be acquired in there is no lock
* write lock can be downgraded to read lock after releasing write lock but read lock can not be upgraded to write lock
* */