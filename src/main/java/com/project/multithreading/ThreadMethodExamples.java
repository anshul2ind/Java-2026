package com.project.multithreading;

public class ThreadMethodExamples {
    static void main() throws InterruptedException {
        Runnable r1 = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName() + " - : " + i + " - "+ Thread.currentThread().getPriority());
                Thread.yield();
            }
            System.out.println("Running");
        };


        var t1 = new Thread(r1, "T1");
        var t2 = new Thread(r1, "T2");

        t1.start();
        t2.start();

        t1.setPriority(Thread.MAX_PRIORITY);
        Thread.sleep(3000);
        t1.setPriority(Thread.MIN_PRIORITY);
        Thread.sleep(1000);
//        Thread.currentThread().sleep(5000);
//        System.out.println("Main : " + Thread.currentThread().getState());
//        Thread.currentThread().interrupt();
//        System.out.println("Main : " + Thread.currentThread().getState());

        t1.interrupt();
        t1.setPriority(Thread.NORM_PRIORITY);
        t1.setName("Name updated");

        t1.join();
    }
}

/*
* Methods
* - Start - To start
* - Run - body of thread
* - join - Caller Thread will wait for called thread called.join()
* - sleep - marks current running Thread.sleep / thread object t1.sleep - thread state - timed_waiting - for specified time period millis
* - setPriority - Thread.MAX_PRIORITY / MIN_PRIORITY / NORM_PRIORITY
* - yield - give chance to other thread
*  - setDaemon - marks the thread daemon which can keep on executing the bg and program will not wait for it finish
* */