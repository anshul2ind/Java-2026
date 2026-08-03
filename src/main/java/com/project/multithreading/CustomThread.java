package com.project.multithreading;

public class CustomThread extends Thread {
    public void run() {
        System.out.println("Current Thread Name from thread : " + Thread.currentThread().getName());
    }

    static void main() throws InterruptedException {
        var t1 = new CustomThread();
        t1.setPriority(Thread.MIN_PRIORITY);
        var t2 = new Thread(new RunnableThreadExample());
        t2.setPriority(Thread.MIN_PRIORITY);
        var r3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Current AnonymousClass Thread Name from thread : " + Thread.currentThread().getName());

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
                }
            }
        };
        var t3 = new Thread(r3);
        t3.setPriority(Thread.MAX_PRIORITY);
        var t4 = new Thread(() -> System.out.println("Current Lambda Thread Name from thread : " + Thread.currentThread().getName() + ", state :" + Thread.currentThread().getState()));
        t4.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("State of " + t4.getName() + " : " + t4.getState());
        t4.start();
        System.out.println("Current Thread Name from PSVM method : " + Thread.currentThread().getName());
        System.out.println("State of " + t4.getName() + " : " + t4.getState());
        System.out.println("State of " + t3.getName() + " : " + t3.getState());
        t3.join();

        System.out.println("State of " + t3.getName() + " : " + t3.getState());
    }
}


class RunnableThreadExample implements Runnable {
    public void run() {
        System.out.println("Current RunnableThreadExample Thread Name from thread : " + Thread.currentThread().getName());
    }
}