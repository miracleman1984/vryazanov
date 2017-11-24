package ru.job4j.monitorysynchronizy;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by vvryazanov on 24.11.2017.
 */
public class MyLock implements Lock {
    private Object lock = new Object();

    public void lock() {
       synchronized (lock) {

       }
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {
        lock.notifyAll();
    }

    public Condition newCondition() {
        return null;
    }



    public static void main(String[] args) {
        final Counter counter = new Counter();
        final MyLock l = new MyLock();
        Callable<String> c = new Callable<String>() {
            public String call() {
                l.lock();
                counter.incremant();
                System.out.println(Thread.currentThread().getName() + " is executing " + counter + " work.");
                System.out.println(Thread.currentThread().getName() + " is finished " + counter + " work.");
                l.unlock();
                return counter.toString();
            }
        };
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread();
        }

    }

}
