package com.project.multithreading;

public class SyncExample {

    static void main() {
        var counter = new Counter();
        var t1 = new ThreadWithCounter(counter, "T1");
        var t2 = new ThreadWithCounter(counter, "T2");
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }
        System.out.println("Counter Value : " + counter.getCount());
    }
}

class ThreadWithCounter extends Thread {
    private Counter counter;

    public ThreadWithCounter(Counter counter, String name) {
        super(name);
        this.counter = counter;
    }

    @Override
    public void run() {
      for (int i = 0; i < 1000; i++) {
        counter.increment();
      }
    }
}

class Counter {
    private int count = 0;

    public synchronized void increment() {
        synchronized (this) {
//            critical section
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
/*
Notes :-
* Race condition when multiple thread access critical section (shared resource) and because of timing result is inconsistent or unpredictable
* synchronized - keyword can be used to prevent the race condition,
*   - after using synchronized keyword ony one thread can access critical section at a time is known as Mutual Exclusion
* Locks - Intrinsic or Explicit
* Intrinsic - Every object has this lock and synchronized keyword uses them or we can they build into every java object
* */