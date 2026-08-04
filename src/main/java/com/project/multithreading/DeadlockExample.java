package com.project.multithreading;

public class DeadlockExample {
    static void main() {
        final Pen pen = new Pen();
        final Paper paper = new Paper();
        Runnable r1 = () -> {
            pen.writeWithPenAndPaper(paper);
        };

        Runnable r2 = () -> {
            paper.writeWithPenAndPaper(pen);
        };
//      r1 and r2 will cause deadlock
        var t1 = new Thread(r1, "T1");
//        var t2 = new Thread(r2, "T2");
//        t2.start();
        t1.start();

//        accquire the lock of pen first then acquire paper lock
        Runnable r3 = () -> {
            synchronized (pen) {
                paper.writeWithPenAndPaper(pen);
            }
        };

        var t3 = new Thread(r3, "T3");
        t3.start();


    }
}

class Paper {
    public synchronized void writeWithPenAndPaper(Pen pen) {
        System.out.println(Thread.currentThread().getName() + " is using paper : " + this + "and trying to finish writing");
        pen.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " is finished using pen : " + this);
    }

}

class Pen {
    public synchronized void writeWithPenAndPaper(Paper paper) {
        System.out.println(Thread.currentThread().getName() + " is using pen : " + this + "and trying to finish writing");
        paper.finishWriting();
    }

    public synchronized void finishWriting() {
        System.out.println(Thread.currentThread().getName() + " is finished using pen : " + this);
    }
}


/*
* Deadlock - Notes
* In multithreading 2 or more threads are blocked forever, waiting for each other to release a resource.
*  - This happens when 2 or more threads has circular dependencies on a set of locks
*  - Formal Definition ( if below 4 conditions are met simultaneously then deadlock is present )
*   - Mutual Exclusion -> only one thread allowed to access resource at a time
*   - Hold and Wait -> a thread holding at least one resource is waiting to acquire additional resource held by other threads
*   - No preemption -> Resources can not be forcibly taken from threads holding them
*   - Circular Wait -> A set of threads is waiting for each other in a circular chain
*   - Consistent Ordering to acquire the lock can prevent the deadlock - making sure when a thread request lock other are not requesting
* */