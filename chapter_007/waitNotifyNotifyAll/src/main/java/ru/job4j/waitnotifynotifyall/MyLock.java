package ru.job4j.waitnotifynotifyall;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by vvryazanov on 24.11.2017.
 */
public class MyLock implements Lock {
    private Object lock = new Object();
    private Boolean isLocked = false;

    @Override
    public String toString() {
        return "MyLock{" +
                "lock=" + lock +
                ", isLocked=" + isLocked +
                '}' + Thread.currentThread().getName() + " " +  lock.hashCode();
    }

    public void  lock() {
        synchronized (lock) {
            while (isLocked) {
                try {
                    System.out.println(String.format("%s wait", Thread.currentThread().getName()));
                    lock.wait();

                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        }
        synchronized (lock) {
            isLocked = true;
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
        System.out.println(Thread.currentThread().getName() + " unlocking");
        isLocked = false;
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Condition newCondition() {
        return null;
    }



    public static void main(String[] args) {
        final SharedObject s = new SharedObject();
        final MyLock l = new MyLock();
        Thread[] th = new Thread[2];

        Runnable r = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName() + " running");
                try {
                    System.out.println(Thread.currentThread().getName() + " is about to lock ");
                    l.lock();
                    System.out.println(Thread.currentThread().getName() + " acquiered a  lock ");
                    s.setVar(Thread.currentThread().getName());
                    l.unlock();
                    System.out.println(Thread.currentThread().getName() + " released the  lock ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        for (int i = 0; i < 2; i++) {
            th[i] = new Thread(r);
        }
        for (int i = 0; i < 2; i++) {
            th[i].start();
        }


    }
}
