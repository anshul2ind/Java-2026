package com.project.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    static void main() {
        final var sbi = new Bank();
        Runnable r1 = () -> {
//            sbi.withdrawSynched(5);
            sbi.withdrawWithReentrantLock(5);
        };
        var t1 = new Thread(r1, "T1");
        var t2 = new Thread(r1, "T2");
        t1.start();
        t2.start();
    }
}

class Bank {
    private int balance = 10;

    private final Lock lock = new ReentrantLock(true);

    public synchronized void withdrawSynched(int amount) {
        System.out.println(Thread.currentThread().getName() + " : attempting : "+ amount);
            if(amount <= balance) {
                System.out.println(Thread.currentThread().getName() + " : proceeding : "+ amount);

                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {

                }
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " : completed, remaining : "+ balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " : insufficient");
            }
    }

    public void withdrawWithReentrantLock(int amount) {
        System.out.println(Thread.currentThread().getName() + " : attempting : "+ amount);
        try {
            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if(amount <= balance) {
                    System.out.println(Thread.currentThread().getName() + " : proceeding : "+ amount);

                    try {
                        Thread.currentThread().sleep(10000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        lock.unlock();
                    }
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " : completed, remaining : "+ balance);
                } else {
                    System.out.println(Thread.currentThread().getName() + " : insufficient");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " : could not get the lock, will try again");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if(Thread.currentThread().isInterrupted()) {
            System.out.println("isInterrupted : " + Thread.currentThread().getName());
        }
    }
}

/*
* Lock - Notes
* - synchronized keywords has no control, it uses intrinsic lock and once a thread has acquired the lock, all other thread trying to access the synced area will have to wait for current thread
* - tryLock - if time not send, will check if the area is not locked by any other thread if it is available then return true else return false instantly, other thread will not have to wait
* - tryLock with time - if area is not available then will wait for specified time, if during that time the lock can not be acquired then it if return false
* - unlock - Always unlock in finally
* - lock - same as synchronized
* - ReenterentLock - Thread who has acquired the lock, lock again and will require to call unlock same number of times, i.e each lock should be paired with unlock, and unlock order also matters otherwise lock may get release earlier
* - lockInterruptibl - lock which can be interrupted
* - fairness - by default ReentrantLocks are unfair i.e. if t1,t2,t,3 request lock then it is not gurrented that lock will assigned in the same order as it was requested, to make it fair - pass true as constructor arg new ReentrantLocks(true)
*   - calling start does not mean lock is requested, start order can be different and based on lock request order, lock will be provided
* */